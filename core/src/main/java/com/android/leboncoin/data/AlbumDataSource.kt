package com.android.leboncoin.data

import com.android.leboncoin.domain.Album
interface AlbumDataSource {

    suspend fun getAllAlbum() : MutableList<Album>

    suspend fun loadAlbum()
}