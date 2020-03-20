package com.example.leboncoint.presentation.album

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.leboncoin.domain.Album
import com.example.leboncoint.framework.Interactors
import com.example.leboncoint.framework.db.LeBonCoinDatabase
import com.example.leboncoint.framework.viewmodel.LeBonCoinViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlbumViewModel(application: Application, interactors: Interactors)
    : LeBonCoinViewModel(application, interactors){


    private val albumDao = LeBonCoinDatabase.getDatabase(getApplication()).albumDao()

    val albums : LiveData<MutableList<Album>> = albumDao.getAllalbums()

    fun loadAlbums(){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                interactors.loadAlbums()
            }
        }
    }

    fun getAlbums() {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                interactors.getAllAlbum()
            }
        }
    }
}
