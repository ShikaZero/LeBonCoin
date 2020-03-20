package com.android.leboncoin.data

import com.android.leboncoin.domain.Album
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumRepository (private val albumDataSource: AlbumDataSource){

    suspend fun loadAlbum() = albumDataSource.loadAlbum()

    suspend fun getAllAlbum() = albumDataSource.getAllAlbum()
}