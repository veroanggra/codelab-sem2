package com.veronica.idn.moviecatalogue.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.veronica.idn.moviecatalogue.R
import com.veronica.idn.moviecatalogue.adapter.PopulerTvAdapter
import com.veronica.idn.moviecatalogue.model.tv.TvPopularItemResponse
import kotlinx.android.synthetic.main.fragment_tv.*

class TVFragment : Fragment() {
    private lateinit var tvViewModel: TVViewModel
    private lateinit var popularTvAdapter: PopulerTvAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tv, container, false)
        tvViewModel = ViewModelProvider(this).get(TVViewModel::class.java)
        tvViewModel.initPopularTv(1)

        tvViewModel.getTvPopularData().observe(viewLifecycleOwner, { tvPopular ->
            getInitTvPopular(tvPopular)
        })
        return root
    }

    private fun getInitTvPopular(tvPopular: List<TvPopularItemResponse>) {
        rv_tv_popular.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager
                    .VERTICAL, true
            )
            popularTvAdapter = PopulerTvAdapter(tvPopular)
            rv_tv_popular.adapter = popularTvAdapter
        }
    }
}