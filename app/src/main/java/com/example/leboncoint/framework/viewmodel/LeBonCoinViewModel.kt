package com.example.leboncoint.framework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.leboncoint.framework.Interactors
import com.example.leboncoint.framework.LeBonCoinApplication

open class LeBonCoinViewModel(application: Application, protected val interactors: Interactors):
    AndroidViewModel(application){

    protected val application : LeBonCoinApplication = getApplication()
}