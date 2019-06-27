package com.sonukumar.app.ui.callback

import android.content.Intent
import android.view.View
import com.sonukumar.app.service.model.ArticleModel
import com.sonukumar.app.ui.ShowDetailsActivity


/**
 * Created by Sonu Kumar on 6/27/2019.
 * Metro Infrasys Pvt Ltd
 * sonuk@metroinfrasys.com
 */

class ArticleClickCallback {
    fun onClickFriend(v: View, articleModel: ArticleModel) {
        val intent = Intent(v.context, ShowDetailsActivity::class.java)
        intent.putExtra("published_date", articleModel.published_date)
        intent.putExtra("title", articleModel.title)
        intent.putExtra("abstract_data", articleModel.abstract_data)
        intent.putExtra("url", articleModel.media!![0]?.media_metadata!![3]?.url)
        v.context.startActivity(intent)
    }
}