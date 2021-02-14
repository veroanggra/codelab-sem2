package com.veronica.idn.newsapp.activity

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.veronica.idn.newsapp.R
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.btn_signup
import kotlinx.android.synthetic.main.activity_sign_up.et_name

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var refUsers : DatabaseReference
    private var  firebaseUserId : String = ""

    companion object{
        fun getLaunchService (from: Context) = Intent(from, SignUpActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        ib_back_signup.setOnClickListener(this)
        btn_signup.setOnClickListener(this)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.ib_back_signup -> startActivity(Intent(SignInActivity.getLaunchService(this)))
            R.id.btn_signup -> signUpUser()
        }
    }

    private fun signUpUser() {
        val fullName: String = et_name.text.toString()
        val email: String = et_email.text.toString()
        val password: String = et_pass_signup.text.toString()
        val confirmPassword: String = et_confirm_pass_signup.text.toString()
        if (fullName == ""){
            Toast.makeText(this, getString(R.string.error_text), Toast.LENGTH_SHORT).show()
        }else if(email == "" ){
            Toast.makeText(this, getString(R.string.error_text), Toast.LENGTH_SHORT).show()
        }else if (password == ""){
            Toast.makeText(this, getString(R.string.error_text), Toast.LENGTH_SHORT).show()
        }else if ((confirmPassword == "").equals(password)){
            Toast.makeText(this, getString(R.string.error_pass), Toast.LENGTH_SHORT).show()
        }else{
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { it ->
                if(it.isSuccessful){
                    firebaseUserId = mAuth.currentUser!!.uid
                    refUsers = FirebaseDatabase.getInstance().reference.child(getString(R.string.text_user)).child(firebaseUserId)
                    val userHashMap = HashMap<String, Any>()
                    userHashMap["uid"] = firebaseUserId
                    userHashMap["fullName"] = fullName
                    userHashMap["email"] = email
                    userHashMap["linkedIn"] = ""
                    userHashMap["instagram"] = ""
                    userHashMap["medium"] = ""
                    userHashMap["photo"]=""

                    refUsers.updateChildren(userHashMap).addOnCompleteListener {
                        if (it.isSuccessful){
                            startActivity(Intent(MainActivity.getLaunchService(this)))
                            finish()
                        }
                    }
                }else{
                    val progress = ProgressDialog(this, R.style.Theme_AppCompat_Light_Dialog)
                    progress.hide()
                    Toast.makeText(this, getString(R.string.error_register) + it.exception!!
                        .message.toString(), Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

}