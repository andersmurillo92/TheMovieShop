package com.themovieshop.data.network

import com.themovieshop.data.model.MovieModel
import com.themovieshop.data.model.MoviesListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiClient {

    @GET("movie/{movie_id}")
    suspend fun getMovieById(@Path("movie_id") id:Int): Response<MovieModel?>

    @GET("list/{list_id}")
    suspend fun getMoviesList(@Path("list_id") id:Int) : Response<MoviesListModel?>
}