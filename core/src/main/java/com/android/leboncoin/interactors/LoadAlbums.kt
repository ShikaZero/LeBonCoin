package com.android.leboncoin.interactors

import com.android.leboncoin.data.AlbumRepository

class LoadAlbums (private val albumRepository: AlbumRepository) {

    suspend operator fun invoke()  = albumRepository.loadAlbum()
}