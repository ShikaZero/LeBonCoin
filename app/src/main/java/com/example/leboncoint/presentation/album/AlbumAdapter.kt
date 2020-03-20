package com.example.leboncoint.presentation.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.leboncoin.domain.Album
import com.example.leboncoint.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumAdapter(
    private val albums : MutableList<Album> = mutableListOf()
) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.titleAlbum
        val albumImageView: ImageView = view.imageAlbum
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_album,parent,false)
        )
    }

    override fun getItemCount() = albums.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var album = albums[position]
        holder.apply {
            this.titleTextView.text = album.title
            Picasso.get()
                .load(album.url)
                .fit()
                .into(albumImageView)
        }
    }
}