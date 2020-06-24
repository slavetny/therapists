package com.slavetny.therapists.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slavetny.therapists.R
import com.slavetny.therapists.data.extension.inflate
import com.slavetny.therapists.domain.model.Therapist

class TherapistsAdapter(private val therapistsList: List<Therapist>) : RecyclerView.Adapter<TherapistsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TherapistsViewHolder =
        TherapistsViewHolder(parent.inflate(R.layout.therapist_item))


    override fun getItemCount(): Int = therapistsList.size

    override fun onBindViewHolder(holder: TherapistsViewHolder, position: Int) {
        holder.bind(therapistsList.get(position))
    }
}