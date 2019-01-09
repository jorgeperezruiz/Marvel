package com.akudreams.marvel.views

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akudreams.marvel.R
import com.akudreams.marvel.data.Comic
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.comic_holder.view.*

class ComicsRecyclerViewAdapter(var comics: List<Comic>) : Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflatedView = inflater.inflate(R.layout.comic_holder, parent, false)
        return ComicViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ComicViewHolder) {
            holder.bind(comics.get(position))
        }
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    class ComicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comic: Comic) = with(itemView) {
            Glide.with(this).load(comic.thumbnailUrl).into(this.comicThumbnail)
            this.comicTitle.text = comic.title
        }
    }
}