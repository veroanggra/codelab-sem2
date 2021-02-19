package com.veronica.idn.newsapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.veronica.idn.newsapp.R
import com.veronica.idn.newsapp.model.ArticlesItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NEWS = "extra_news"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()
        fb_back_detail.setOnClickListener { startActivity(Intent(MainActivity.getLaunchService(this))) }
        val news = intent.getParcelableExtra<ArticlesItem>("EXTRA_NEWS") as ArticlesItem
        Glide.with(this).load(news.urlToImage).into(iv_detail)
        tv_detail_title.text = news.title.toString()
        tv_name_detail.text = news.author.toString()
        tv_date_detail.text = news.publishedAt.toString()
        tv_desc_detail.text = news.description.toString()
        tv_content_detail.text = news.content.toString()
    }
}