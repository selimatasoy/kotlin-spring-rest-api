package com.selimatasoy.kotlinspringrestapi.features.starwars.data

import com.selimatasoy.features.starwars.model.Movie
import com.selimatasoy.kotlinspringrestapi.features.starwars.remote.StarWarsRemote
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class StarWarsDataImpl(private val remote: StarWarsRemote) : StarWarsData {
    override suspend fun getMovie(): Movie {
        return remote.getMovie()
    }
}