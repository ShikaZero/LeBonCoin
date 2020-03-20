package com.example.leboncoint.framework.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.leboncoint.framework.Interactors
import java.lang.IllegalStateException

object LeBonCoinViewModelFactory : ViewModelProvider.Factory{

    lateinit var application: Application

    lateinit var dependencies: Interactors

    fun inject(application: Application, dependencies: Interactors){
        LeBonCoinViewModelFactory.application = application
        LeBonCoinViewModelFactory.dependencies = dependencies
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (LeBonCoinViewModel::class.java.isAssignableFrom(modelClass)){
            return modelClass.getConstructor(Application::class.java,Interactors::class.java)
                .newInstance(application, dependencies)
        } else{
            throw IllegalStateException("ViewModel must extend AlbumViewModel")
        }
    }
}