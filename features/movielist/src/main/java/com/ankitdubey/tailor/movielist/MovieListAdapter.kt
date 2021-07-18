package com.ankitdubey.tailor.movielist

/**
 * Created by Ankit Dubey on 18,July,2021
 */

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ankitdubey.tailor.core.extensions.loadImgUrl
import com.ankitdubey.tailor.core.model.IMAGE_BASE_URL
import com.ankitdubey.tailor.core.model.IMAGE_BASE_URL_SW
import com.ankitdubey.tailor.core.model.Movie
import com.ankitdubey.tailor.movielist.databinding.ItemMovieListBinding

class MovieListAdapter (val clickCallback : (Movie) -> Unit):
    RecyclerView.Adapter<MovieListAdapter.MyViewHolder>() {
    var items: List<Movie> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val withDataBinding = ItemMovieListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(withDataBinding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val movie = items[position]

        holder.viewDataBinding.also {
            it.title.text = movie.originalTitle
            it.img.loadImgUrl(IMAGE_BASE_URL_SW+movie.posterPath)

            it.root.setOnClickListener {
                clickCallback(movie)
            }
        }
    }

    class MyViewHolder(val viewDataBinding: ItemMovieListBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

    }
}