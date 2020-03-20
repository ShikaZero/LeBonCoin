package com.example.leboncoint.framework

import android.content.Context
import androidx.lifecycle.LiveData
import com.android.leboncoin.data.AlbumDataSource
import com.android.leboncoin.domain.Album
import com.example.leboncoint.framework.db.AlbumEntity
import com.example.leboncoint.framework.db.LeBonCoinDatabase
import com.example.leboncoint.framework.services.AlbumServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.Executors

class RoomAlbumDataSource(context : Context) : AlbumDataSource {

    private val albumDao = LeBonCoinDatabase.getDatabase(context).albumDao()

    private var okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private var retrofit = Retrofit.Builder()
        .baseUrl(LeBonCoinApplication.ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private var albumServices = retrofit.create((AlbumServices::class.java))

    override suspend fun loadAlbum() = albumServices.getAllAlbumServices()!!.enqueue(object :Callback<List<Album>>{
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Timber.e(t)
            }

            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {

                    if (response.body() != null ) {
                        GlobalScope.launch {
                                albumDao.addAlbums(response.body()!!.map{
                                    AlbumEntity(
                                        it.albumId,
                                        it.id,
                                        it.title,
                                        it.url,
                                        it.thumbnailUrl
                                    )
                                })
                            }
                        }
                    }
        })

    override suspend fun getAllAlbum(): MutableList<Album> = albumDao.getAllalbumsStaticData()

}