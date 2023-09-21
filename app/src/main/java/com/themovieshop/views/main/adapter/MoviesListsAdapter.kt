package com.themovieshop.views.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.themovieshop.R
import com.themovieshop.databinding.ItemMoviesListBinding
import com.themovieshop.domain.model.MoviesList
import com.themovieshop.util.ItemActionListener

private const val TAG = "MoviesListsAdapter"

class MoviesListsAdapter(
    private val itemActionListener: ItemActionListener
) : RecyclerView.Adapter<MoviesListsAdapter.ViewHolder>() {

    private val list = mutableListOf<MoviesList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movies_list, parent, false
            ), parent, itemActionListener
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int =
        list.size

    fun onUpdateData(items: List<MoviesList>) {
        list.clear()
        list.addAll(items)
        Log.d(TAG, "METHOD CALLED: updateData()")
        notifyDataSetChanged()
    }

    class ViewHolder(
        view: View,
        private val parent: ViewGroup,
        private val itemActionListener: ItemActionListener
    ) : RecyclerView.ViewHolder(view) {

        val binding = ItemMoviesListBinding.bind(view)

        fun bind(item: MoviesList) {
            with(binding) {
                val adapter = MovieAdapter(itemActionListener)
                rvMovies.layoutManager =
                    LinearLayoutManager(parent.context, RecyclerView.HORIZONTAL, false)
                rvMovies.adapter = adapter
                adapter.onUpdateData(item.results)
                tvGenreName.text = item.name
            }

        }
    }

}