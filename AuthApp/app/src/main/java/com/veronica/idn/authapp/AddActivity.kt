package com.veronica.idn.authapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.veronica.idn.authapp.model.Recipes
import com.veronica.idn.authapp.utils.Const.COLLECTION_PATH
import com.veronica.idn.authapp.utils.Const.setTimeStamp
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    private var isEdit = false
    private var recipes : Recipes? = null
    private val db = FirebaseFirestore.getInstance()
    private  val recipeCollection = db.collection(COLLECTION_PATH)

    companion object{
        const val EXTRA_DATA = "extra_data"
        const val EDIT_DATA = "edit_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        isEdit = intent.getBooleanExtra(EDIT_DATA, false)
        recipes = intent.getParcelableExtra(EXTRA_DATA)
        btn_save.setOnClickListener {
            saveData()
        }
        setUpView()
    }

    private fun setUpView() {
        if (isEdit){
            btn_save.text = getString(R.string.text_update)
            et_name_aad.text = Editable.Factory.getInstance().newEditable(recipes?.recipeName)
            et_jenis_add.text = Editable.Factory.getInstance().newEditable(recipes?.recipeJenis)
        }

    }

    private fun saveData() {
        setData(recipes?.recipeId)
    }

    private fun setData(recipeId: String?) {
        createRecipe(recipeId).addOnCompleteListener {
            if (it.isSuccessful){
                if (isEdit){
                    Toast.makeText(this, "Edit Success", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Add Success", Toast.LENGTH_SHORT).show()
                }
                finish()
            }else{
                Toast.makeText(this, "Add Failed", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Error Added Data ${it.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createRecipe(recipeId: String?):Task<Void> {
        val writeBatch = db.batch()
        val path = COLLECTION_PATH + setTimeStamp().toString()
        val id = recipeId ?: path
        val name = et_name_aad.text.toString()
        val jenis = et_jenis_add.text.toString()
        val recipe = Recipes(id, name, jenis)
        writeBatch.set(recipeCollection.document(id), recipe)
        return  writeBatch.commit()
    }
}