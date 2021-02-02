package com.veronica.idn.authapp.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.veronica.idn.authapp.model.Recipes

class RecipeAdapter(private val context: Context,
                    private val collection: CollectionReference,
                    options : FirestoreRecyclerOptions<Recipes>)
    :FirestoreRecyclerAdapter<Recipes, RecipeAdapter.ViewHolder>(options) {

    class ViewHolder(val view : View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecipeAdapter.ViewHolder, position: Int, model: Recipes) {
        TODO("Not yet implemented")
    }


}