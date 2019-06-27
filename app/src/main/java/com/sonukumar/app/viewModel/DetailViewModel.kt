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

class DetailViewModel(application: Application, periodId: Int, apiKey:String): AndroidViewModel(application) {

}