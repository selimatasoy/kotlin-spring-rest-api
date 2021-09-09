package com.selimatasoy.kotlinspringrestapi.features.starwars.service

import com.selimatasoy.features.starwars.model.Movie
import com.selimatasoy.kotlinspringrestapi.features.starwars.remote.StarWarsRemote
import org.springframework.stereotype.Service

@Service
class StarWarsServiceImpl(private val remote: StarWarsRemote) : StarWarsService {
    override suspend fun getMovie(): Movie {
        return remote.getMovie()
    }
}