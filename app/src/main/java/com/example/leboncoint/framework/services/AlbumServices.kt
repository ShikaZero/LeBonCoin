package com.example.leboncoint.framework.services

import com.android.leboncoin.domain.Album
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface AlbumServices {

    @Headers("Content-Type: application/json")
    @GET("img/shared/technical-test.json")
    fun getAllAlbumServices() : Call<List<Album>>?

}