package com.sonukumar.app.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sonukumar.app.R
import com.sonukumar.app.databinding.ArticleItemBinding
import com.sonukumar.app.service.model.ArticleModel
import com.sonukumar.app.ui.callback.ArticleClickCallback


/**
 * Created by Sonu Kumar on 6/27/2019.
 */


class NyArticleListAdapter(private val articleList: MutableList<ArticleModel>): RecyclerView.Adapter<NyArticleListAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = DataBindingUtil.inflate<ArticleItemBinding>(LayoutInflater.from(parent.context), R.layout.article_item,
            parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(viewHolder: ArticleViewHolder, position: Int) {
        val articleModel = articleList.get(position)

        Glide.with(viewHolder.binding.profileImage.getContext())
            .load(articleModel.media!![0].media_metadata!![0].url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(viewHolder.binding.profileImage)
        viewHolder.binding.handlers = ArticleClickCallback()
        viewHolder.binding.articleModel = articleModel;
        viewHolder.binding.executePendingBindings()
    }

    class ArticleViewHolder(val binding: ArticleItemBinding) : RecyclerView.ViewHolder(binding.root)
}