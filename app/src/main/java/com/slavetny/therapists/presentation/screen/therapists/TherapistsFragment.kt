package com.slavetny.therapists.presentation.screen.therapists

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.slavetny.cryptocurrencyrate.presentation.base.BaseFragment
import com.slavetny.therapists.R
import com.slavetny.therapists.domain.extension.observeNotNull
import com.slavetny.therapists.presentation.adapter.TherapistsAdapter
import kotlinx.android.synthetic.main.fragment_therpists.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TherapistsFragment : BaseFragment<TherapistsViewModel>(R.layout.fragment_therpists) {

    override val viewModel: TherapistsViewModel by viewModel()
    private lateinit var adapter: TherapistsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.therapistsList.observeNotNull(requireActivity()) {
            adapter = TherapistsAdapter(it)

            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        frg_recycler_view.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        frg_recycler_view.adapter = adapter
    }
}