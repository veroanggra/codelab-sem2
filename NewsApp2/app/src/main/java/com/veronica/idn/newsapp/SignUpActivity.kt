package com.veronica.idn.newsapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
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
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.ib_back_signup -> startActivity(Intent(SignInActivity.getLaunchService(this)))
        }
    }
}