package com.themovieshop.data.model

import java.io.Serializable

data class MoviesListModel(
    val id:Int? = null,
    val description:String = "",
    var results:List<MovieModel> = emptyList(),
    val backdrop_path:String = "",
    val name:String = "",
    val poster_path:String = ""
):Serializable