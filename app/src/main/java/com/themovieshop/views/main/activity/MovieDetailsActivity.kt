package com.themovieshop.views.main.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.themovieshop.data.model.baseUrlImg
import com.themovieshop.databinding.ActivityMovieDetailsBinding
import com.themovieshop.domain.model.Movie
import com.themovieshop.util.UIBehavior
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsActivity : AppCompatActivity(), UIBehavior {

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initUI()
    }

    override fun initUI() {
        val item = intent?.getSerializableExtra("movie") as Movie
        with(binding){
            Glide.with(applicationContext).load("$baseUrlImg${item.backdrop_path}")
                .into(backdropImageView)
            Glide.with(applicationContext).load("$baseUrlImg${item.poster_path}")
                .into(posterImageView)
            titleTextView.text = item.title
            descriptionTextView.text = item.overview
            dateTextView.text = "Release: ${item.release_date}"
            popularityTextView.text = "Popularity: ${item.popularity}"
            averageTextView.text = "Average: ${item.vote_average}"
        }
    }
}