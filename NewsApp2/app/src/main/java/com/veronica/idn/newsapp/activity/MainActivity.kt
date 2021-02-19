package com.veronica.idn.newsapp.activity

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.veronica.idn.newsapp.NewsAdapter
import com.veronica.idn.newsapp.R
import com.veronica.idn.newsapp.model.ArticlesItem
import com.veronica.idn.newsapp.model.ResponseNews
import com.veronica.idn.newsapp.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.news_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val date = getCurrentDateTime()

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    companion object {
        fun getLaunchService(from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        ib_profile_main.setOnClickListener(this)
        tv_date_main.text = date.toString("dd/MM/yyyy")
        getNews()

    }
    private fun getNews() {
        val country = "id"
        val apiKey = "d7525c19bc0f4a928614e46943fb20e7"


        val loading = ProgressDialog.show(this, "Request Data", "Loading..")
        RetrofitConfig.getInstace().getNewsData(country, apiKey).enqueue(
            object : Callback<ResponseNews> {
                override fun onResponse(
                    call: Call<ResponseNews>,
                    response: Response<ResponseNews>
                ) {
                    Log.d("Response", "Success" + response.body()?.articles)
                    loading.dismiss()
                    if (response.isSuccessful) {
                        val status = response.body()?.status
                        if (status.equals("ok")) {
                            Toast.makeText(this@MainActivity, "Data Success !", Toast.LENGTH_SHORT)
                                .show()
                            val newsData = response.body()?.articles
                            val newsDatImage = response.body()!!
                            Glide.with(this@MainActivity)
                                .load(newsDatImage.articles?.component5()?.urlToImage).centerCrop()
                                .into(iv_main)
                            tv_highlight.text =
                                newsDatImage.articles?.component5()?.title.toString()
                            tv_name_author.text =
                                newsDatImage.articles?.component5()?.author.toString()

                            val newsAdapter = NewsAdapter(this@MainActivity, newsData)
                            rv_main.adapter = newsAdapter
                            rv_main.layoutManager = LinearLayoutManager(this@MainActivity)

                        } else {
                            Toast.makeText(this@MainActivity, "Data Failed !", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                }

                override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                    Log.d("Response", "Failed : " + t.localizedMessage)
                    loading.dismiss()
                }

            }
        )

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ib_profile_main -> startActivity(Intent(ProfileActivity.getLaunchService(this)))
        }
    }
}

