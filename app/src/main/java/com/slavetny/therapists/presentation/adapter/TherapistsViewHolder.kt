package com.slavetny.therapists.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.slavetny.therapists.domain.model.Therapist
import kotlinx.android.synthetic.main.therapist_item.view.*

class TherapistsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(therapist: Therapist) {
        itemView.therapist_name.text = therapist.firstName + " " + therapist.lastName
        itemView.therapist_description.text = therapist.description

        Glide.with(itemView.context)
            .load(therapist.imageS3Key)
            .into(itemView.therapist_photo)
    }
}