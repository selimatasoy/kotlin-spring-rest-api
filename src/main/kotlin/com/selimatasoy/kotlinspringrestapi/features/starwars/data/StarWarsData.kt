package com.selimatasoy.kotlinspringrestapi.features.starwars.data

import com.selimatasoy.features.starwars.model.Movie
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

interface StarWarsData {
    suspend fun getMovie(): Movie
}