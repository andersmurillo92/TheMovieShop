package com.themovieshop.data.network

import android.util.Log
import com.themovieshop.data.dao.MovieDAO
import com.themovieshop.data.entity.MovieEntity
import com.themovieshop.data.model.MoviesListModel
import com.themovieshop.domain.model.Movie
import com.themovieshop.domain.model.MoviesList
import com.themovieshop.domain.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService,
    private val movieDAO:MovieDAO
) {

    companion object {
        private const val TAG = "MovieRepository"
    }

    suspend fun getMoviesListFromAPI(id: Int): MoviesList =
        withContext(Dispatchers.IO) {
            try {
                Log.i(TAG, "METHOD CALLED: getMoviesListFromAPI(long)")
                val result: MoviesListModel = movieService.getMoviesList(id)
                Log.i(TAG, "$result")
                result.toDomain()
            } catch (ex: Exception) {
                Log.i(TAG, "Exception: $ex")
                MoviesList()
            }
        }


    suspend fun insertAllMoviesInRoom(items:List<MovieEntity>){
        try {
            movieDAO.insertAll(items)
        } catch (ex:Exception){
            Log.i(TAG, "Exception: $ex")
        }
    }

    suspend fun getMoviesListFromLocal(): List<Movie> {
        val items:List<MovieEntity> = movieDAO.getAllMovies()
        return items.map { it.toDomain() }
    }

    suspend fun getMoviesByName(q:String): List<Movie> {
        val items = movieDAO.getMoviesByName(q)
        return items.map { it.toDomain() }
    }

    suspend fun clearAllMovies(){
        movieDAO.deleteAllMovies()
    }

}