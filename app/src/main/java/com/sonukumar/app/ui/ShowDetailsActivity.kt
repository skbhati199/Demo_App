package com.sonukumar.app.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity;
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sonukumar.app.R
import com.sonukumar.app.databinding.ActivityShowDetailsBinding
import com.sonukumar.app.service.model.ArticleModel
import com.sonukumar.app.viewModel.DetailViewModel

import kotlinx.android.synthetic.main.activity_show_details.*

class ShowDetailsActivity : AppCompatActivity() {

    private var binding: ActivityShowDetailsBinding? = null
    private var viewModel: DetailViewModel? = null
    private var articleModel: ArticleModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_details)
        articleModel = intent.getSerializableExtra("data") as ArticleModel
        binding?.articleModel = articleModel
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java!!)

        Glide.with(binding?.profileImage?.getContext()!!)
            .load(articleModel!!.media!![0].media_metadata!![3].url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding?.profileImage!!)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
