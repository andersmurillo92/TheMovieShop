package com.themovieshop.views.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.themovieshop.R
import com.themovieshop.data.model.baseUrlImg
import com.themovieshop.databinding.ItemMovieBinding
import com.themovieshop.domain.model.Movie
import com.themovieshop.util.ItemActionListener

private const val TAG = "MovieAdapter"

class MovieAdapter(
    val itemActionListener: ItemActionListener
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val list = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie, parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = list[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            itemActionListener.onClickItem(movie, position)
        }
    }

    override fun getItemCount(): Int = list.size

    fun onUpdateData(items: List<Movie>) {
        list.clear()
        list.addAll(items)
        Log.d(TAG, "METHOD CALLED: updateData()")
        notifyDataSetChanged()
    }

    fun isEmpty(): Boolean = list.isEmpty()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemMovieBinding.bind(view)

        fun bind(item: Movie) {
            //binding.titleTextView.text = item.title
            //Picasso.get().load("$baseUrlImg${item.poster_path}").into(binding.movieImageView)
            Glide.with(itemView).load("$baseUrlImg${item.poster_path}")
                .into(binding.movieImageView)
        }

    }

}