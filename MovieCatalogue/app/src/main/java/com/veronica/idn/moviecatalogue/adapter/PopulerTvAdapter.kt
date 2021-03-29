package com.veronica.idn.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.veronica.idn.moviecatalogue.BuildConfig
import com.veronica.idn.moviecatalogue.R
import com.veronica.idn.moviecatalogue.model.tv.TvPopularItemResponse
import kotlinx.android.synthetic.main.item_tv_populer.view.*

class PopulerTvAdapter(var listTvPopular: List<TvPopularItemResponse>) :
    RecyclerView.Adapter<PopulerTvAdapter.TvPopularViewHolder>() {

    class TvPopularViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(tvpopular: TvPopularItemResponse) {
            with(itemView) {
                Glide.with(context).load(BuildConfig.IMAGE_URL + tvpopular.poster_path)
                    .into(iv_tv_popular)
                tv_title_tv_popular.text = tvpopular.name
                tv_language_tv_popular.text = tvpopular.original_language
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopulerTvAdapter.TvPopularViewHolder {
        return TvPopularViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tv_populer, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PopulerTvAdapter.TvPopularViewHolder, position: Int) {
        holder.bind(listTvPopular.get(position))
    }

    override fun getItemCount(): Int = listTvPopular.size
}