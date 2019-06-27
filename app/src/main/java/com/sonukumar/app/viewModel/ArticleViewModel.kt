package com.sonukumar.app.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.ObservableField
import android.support.v7.app.AppCompatActivity
import com.sonukumar.app.service.model.ArticleModel
import com.sonukumar.app.service.respository.ArticlesRepository


/**
 * Created by Sonu Kumar on 6/27/2019.
 */

@Suppress("UNCHECKED_CAST")
class ArticleViewModel(application: Application, periodId: Int, apiKey:String): AndroidViewModel(application) {
    private val articlesObservable: LiveData<ArticleModel> = ArticlesRepository.getInstance().getArticleList(periodId, apiKey)
    var article: ObservableField<ArticleModel> = ObservableField()

    fun getObservableArticle(): LiveData<ArticleModel> {
        return articlesObservable
    }

    fun setArticle(project: ArticleModel) {
        this.article.set(project)
    }

    class Factory(private val application: AppCompatActivity, private val articleID: Int, private val apiKey: String) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return ArticleViewModel(application.application, articleID, apiKey) as T
        }
    }
}