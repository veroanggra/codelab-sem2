package com.veronica.idn.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.veronica.idn.moviecatalogue.adapter.PopulerMovieAdapter
import com.veronica.idn.moviecatalogue.R
import com.veronica.idn.moviecatalogue.adapter.UpcomingMovieAdapter
import com.veronica.idn.moviecatalogue.model.movie.MovieItemResponse
import com.veronica.idn.moviecatalogue.model.movie.UpcomingResponse
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var populerMovieAdapter: PopulerMovieAdapter
    private lateinit var upcomingMovieAdapter: UpcomingMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_movie, container, false)

        movieViewModel =
            ViewModelProvider(this).get(MovieViewModel::class.java)

        //popular
        movieViewModel.init(1)
        movieViewModel.getData()
            .observe(viewLifecycleOwner, Observer { popularMovie ->
                getInitPopular(popularMovie)
            })

        //upcoming
        movieViewModel.initUp(1)
        movieViewModel.getDataUpcoming().observe(viewLifecycleOwner, Observer { movieUpcoming ->
            getInitUpcoming(movieUpcoming)
        })
        return root
    }

    private fun getInitUpcoming(movieUpcoming: List<UpcomingResponse>) {
        rv_upcoming.apply {
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, true)
            upcomingMovieAdapter = UpcomingMovieAdapter(movieUpcoming)
            rv_upcoming.adapter = upcomingMovieAdapter
        }

    }


    private fun getInitPopular(popularMovie: List<MovieItemResponse>) {
        rv_popular.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL, true
            )
            populerMovieAdapter = PopulerMovieAdapter(popularMovie)
            rv_popular.adapter = populerMovieAdapter
        }
    }
}