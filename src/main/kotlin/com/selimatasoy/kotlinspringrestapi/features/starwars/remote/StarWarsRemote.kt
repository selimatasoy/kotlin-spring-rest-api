package com.selimatasoy.kotlinspringrestapi.features.starwars.remote

import com.selimatasoy.features.starwars.model.Movie
import org.springframework.stereotype.Component

interface StarWarsRemote {
    suspend fun getMovie(): Movie
}