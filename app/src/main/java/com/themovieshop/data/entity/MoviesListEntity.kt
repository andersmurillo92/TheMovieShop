package com.themovieshop.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.themovieshop.domain.model.MoviesList

@Entity(tableName = "movie_list")
data class MoviesListEntity(
    @PrimaryKey
    @ColumnInfo(name="movies_list_id") val id:Int?,
    @ColumnInfo(name="description") val description:String = "",
    @ColumnInfo(name="backdrop_path") val backdrop_path:String = "",
    @ColumnInfo(name="name") val name:String = "",
    @ColumnInfo(name="poster_path") val poster_path:String = ""
)

fun MoviesList.toDatabase() = MoviesListEntity(
    id,
    description,
    backdrop_path,
    name,
    poster_path
)