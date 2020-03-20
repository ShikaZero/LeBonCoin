package com.android.leboncoin.interactors

import com.android.leboncoin.data.AlbumRepository

class GetAllAlbum ( private val albumRepository: AlbumRepository) {

    suspend operator fun invoke() = albumRepository.getAllAlbum()
}