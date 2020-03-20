package com.example.leboncoint.framework.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.android.leboncoin.domain.Album

@Dao
interface AlbumsDao {

    @Insert(onConflict = REPLACE)
    suspend fun addAlbums(albumEntity: List<AlbumEntity>)

    @Query("SELECT * FROM album")
    fun getAllalbums(): LiveData<MutableList<Album>>

    @Query("SELECT * FROM album")
    fun getAllalbumsStaticData(): MutableList<Album>
}