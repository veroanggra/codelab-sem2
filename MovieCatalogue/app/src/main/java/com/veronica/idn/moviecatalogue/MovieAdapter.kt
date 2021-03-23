package com.veronica.idn.moviecatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.veronica.idn.moviecatalogue.model.ResultsItem
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(var context: Context, var listMovie: List<ResultsItem>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movies: ResultsItem) {
            with(itemView) {
                Glide.with(context).load(BuildConfig.IMAGE_URL + movies.posterPath)
                    .into(iv_movie_poster)
                tv_title_movie.text = movies.title
                itemView.setOnClickListener{

                }
            }
        }

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie.get(position))
    }

    override fun getItemCount(): Int = listMovie.size


}