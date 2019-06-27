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
    fun onClickFriend(v: View, articlePojo: ArticleModel) {
        val intent = Intent(v.context, ShowDetailsActivity::class.java)
        intent.putExtra("data", articlePojo)
        v.context.startActivity(intent)
    }
}