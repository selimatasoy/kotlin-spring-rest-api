package com.selimatasoy.kotlinspringrestapi.features.starwars.remote

import com.selimatasoy.kotlinspringrestapi.features.starwars.model.Movie

interface StarWarsRemote {
    suspend fun getMovie(): Movie
}