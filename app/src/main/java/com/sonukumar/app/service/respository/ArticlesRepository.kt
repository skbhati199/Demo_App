package com.sonukumar.app.service.respository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.sonukumar.app.service.model.ArticleModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Sonu Kumar on 6/27/2019.
 */

class ArticlesRepository {
    private val API_NY_TIMES_URL = "http://api.nytimes.com/"
    private var nyTimeService: NYTimeService?=null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_NY_TIMES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        nyTimeService = retrofit.create(NYTimeService::class.java)
    }

    companion object {
        private var articlesRepository: ArticlesRepository? = null
        @Synchronized
        @JvmStatic
        fun getInstance(): ArticlesRepository {
            if (articlesRepository == null) {
                articlesRepository = ArticlesRepository()
            }
            return articlesRepository!!
        }
    }


    fun getArticleList(periodId: Int, apiKey:String): LiveData<ArticleModel> {
        val data = MutableLiveData<ArticleModel>()

        nyTimeService?.getArticleList(periodId, apiKey)?.enqueue(object : Callback<ArticleModel> {
            override fun onResponse(call: Call<ArticleModel>, response: Response<ArticleModel>) {
                data.value=response.body()
            }

            override fun onFailure(call: Call<ArticleModel>, t: Throwable) {
                data.value=null
            }
        })

        return data
    }



}