package com.example.leboncoint.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="album")
data class AlbumEntity (

    @PrimaryKey(autoGenerate = true) val albumId : Int = 0 ,
    val id : Int = 0,
    val title : String = "",
    val url : String = "",
    val thumbnailUrl :  String = ""
)