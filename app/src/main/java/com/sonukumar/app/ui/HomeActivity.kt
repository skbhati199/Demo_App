package com.sonukumar.app.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.sonukumar.app.R
import com.sonukumar.app.service.model.ArticleModel
import com.sonukumar.app.ui.adapter.NyArticleListAdapter
import com.sonukumar.app.ui.callback.ArticleClickCallback
import com.sonukumar.app.utils.AppConstants
import com.sonukumar.app.viewModel.ArticleViewModel


class HomeActivity : AppCompatActivity() {
    private var mutableList = mutableListOf<ArticleModel>()


    private var activityHomeBinding: com.sonukumar.app.databinding.ActivityHomeBinding? = null

    private var viewModel: ArticleViewModel? = null
    private var projectAdapter: NyArticleListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setRecyclerView()

        viewModel = ViewModelProviders.of(this, ArticleViewModel.Factory(this, 7, AppConstants.API_KY))
            .get(ArticleViewModel::class.java)

        viewModel!!.getObservableArticle().observe(this, Observer { articleModel ->
            if (articleModel != null) {
//                binding?.isLoading=false
                mutableList.clear()
                articleModel.results?.toMutableList()?.let { mutableList.addAll(it) }
                projectAdapter?.notifyDataSetChanged()

            }
        })


    }

    private fun setRecyclerView() {
        projectAdapter = NyArticleListAdapter(mutableList)
        activityHomeBinding?.rvNyArticles?.layoutManager = LinearLayoutManager(this);
        activityHomeBinding?.rvNyArticles?.adapter = projectAdapter
    }
}
