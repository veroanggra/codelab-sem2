package com.veronica.idn.recipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_recipe.view.*

class ItemAdapter(private val listRecipe: ArrayList<Recipe>) :
    RecyclerView.Adapter<ItemAdapter.ListViewHolder>() {

    private var onItemClickCallBack: OnItemClickCallBack? = null

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    interface OnItemClickCallBack {
        fun onItemClicked(data: Recipe)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(recipe: Recipe) {
            with(itemView) {
                Glide.with(itemView.context).load(recipe.photo)
                    .apply(
                        RequestOptions()
                            .override(150, 190)
                    )
                    .into(iv_item_food)
                tv_name_food.text = recipe.name
                tv_desc_food.text = recipe.description

                itemView.setOnClickListener {
                    onItemClickCallBack?.onItemClicked(recipe)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ListViewHolder, position: Int) {
        holder.bind(listRecipe[position])
    }

    override fun getItemCount(): Int = listRecipe.size

}