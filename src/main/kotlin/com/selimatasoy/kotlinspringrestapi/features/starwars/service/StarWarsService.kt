package com.selimatasoy.kotlinspringrestapi.features.starwars.service

import com.selimatasoy.kotlinspringrestapi.features.starwars.model.Movie

interface StarWarsService {
    suspend fun getMovie(): Movie
}