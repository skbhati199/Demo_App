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

        var title = intent.getStringExtra("title");
        var published_date = intent.getStringExtra("published_date");
        var abstract_data = intent.getStringExtra("abstract_data");
        var url = intent.getStringExtra("url");

        binding?.title?.text = title
        binding?.publishDate?.text = published_date
        binding?.abstractData?.text = abstract_data




        Glide.with(binding?.profileImage?.getContext()!!)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding?.profileImage!!)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
