package com.themovieshop.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.themovieshop.data.dao.MovieDAO
import com.themovieshop.data.dao.MoviesListDAO
import com.themovieshop.data.entity.MovieEntity
import com.themovieshop.data.entity.MoviesListEntity

@Database(entities = [MovieEntity::class, MoviesListEntity::class], version = 1)
abstract class TheMovieDatabase: RoomDatabase() {
    abstract fun getMovieDAO(): MovieDAO
    abstract fun getMoviesListDAO(): MoviesListDAO
}