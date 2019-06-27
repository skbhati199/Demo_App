package com.sonukumar.app.service.respository

import com.sonukumar.app.service.model.ArticleModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by Sonu Kumar on 6/27/2019.
 * Metro Infrasys Pvt Ltd
 * sonuk@metroinfrasys.com
 */

interface NYTimeService {
    @GET("svc/mostpopular/v2/mostviewed/all-sections/{period}.json")
    fun getArticleList(@Path("period") periodId: Int, @Query("api-key") apiKey:String): Call<ArticleModel>

}