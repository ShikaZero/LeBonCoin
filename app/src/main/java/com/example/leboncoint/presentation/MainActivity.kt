package com.example.leboncoint.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.leboncoin.domain.Album
import com.example.leboncoint.R
import com.example.leboncoint.framework.viewmodel.LeBonCoinViewModelFactory
import com.example.leboncoint.presentation.album.AlbumAdapter
import com.example.leboncoint.presentation.album.AlbumViewModel
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : AlbumViewModel
    private lateinit var albumAdapter : AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, LeBonCoinViewModelFactory).get(AlbumViewModel::class.java)
        viewModel.loadAlbums()

        viewModel.albums.observe(this, Observer {
            newAlbums -> fillAlbumList(newAlbums)
        } )

    }

    private fun fillAlbumList(newAlbums: MutableList<Album>?) {
        Timber.d("newAlbums ==> %s",newAlbums)
        albumAdapter = AlbumAdapter(newAlbums!!)
        albumsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = AlbumAdapter(newAlbums)
        }
    }
}
