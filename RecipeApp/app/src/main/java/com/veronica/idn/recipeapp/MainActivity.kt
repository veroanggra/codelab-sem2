package com.veronica.idn.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        rv_main.setHasFixedSize(true)
        list.addAll(getRecipe())
        showRecycler()
    }

    private fun showToast(recipe: Recipe) {
        Toast.makeText(
            this, "Makanan favorit kamu ${recipe.name}",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showRecycler() {
        rv_main.layoutManager = LinearLayoutManager(this)
        val listRecipe = ItemAdapter(list)
        rv_main.adapter = listRecipe
        listRecipe.setOnItemClickCallBack(object : ItemAdapter.OnItemClickCallBack {
            override fun onItemClicked(data: Recipe) {
                showToast(data)
            }
        })
    }


    private fun getRecipe(): ArrayList<Recipe> {
        val dataName = resources.getStringArray(R.array.name_food)
        val dataDesc = resources.getStringArray(R.array.desc_food)
        val dataIngredients = resources.getStringArray(R.array.ingredients)
        val dataSteps = resources.getStringArray(R.array.steps)
        val dataRating = resources.getIntArray(R.array.rating)
        val dataPhoto = resources.getStringArray(R.array.photo_food)
        val listRecipes = ArrayList<Recipe>()
        for (position in dataName.indices) {
            val recipes = Recipe(
                dataName[position],
                dataDesc[position],
                dataIngredients[position],
                dataSteps[position],
                dataRating[position],
                dataPhoto[position]
            )
            listRecipes.add(recipes)
        }
        return listRecipes
    }

}