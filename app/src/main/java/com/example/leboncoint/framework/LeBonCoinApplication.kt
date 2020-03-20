package com.example.leboncoint.framework

import android.app.Application
import com.android.leboncoin.data.AlbumRepository
import com.android.leboncoin.interactors.LoadAlbums
import com.android.leboncoin.interactors.GetAllAlbum
import com.example.leboncoint.framework.viewmodel.LeBonCoinViewModelFactory

class LeBonCoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val albumRepository = AlbumRepository(RoomAlbumDataSource(this))

        LeBonCoinViewModelFactory.inject(
            this,
            Interactors(
                LoadAlbums(albumRepository),
                GetAllAlbum(albumRepository)
            )
        )
    }

    companion object{
        val ENDPOINT = "https://static.leboncoin.fr/"
    }
}