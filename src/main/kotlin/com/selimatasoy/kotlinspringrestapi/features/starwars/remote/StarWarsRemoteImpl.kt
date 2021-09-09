package com.selimatasoy.kotlinspringrestapi.features.starwars.remote

import com.selimatasoy.features.starwars.model.Movie
import com.selimatasoy.kotlinspringrestapi.httpclient.HttpServiceImpl
import io.ktor.client.request.*
import org.springframework.stereotype.Component

@Component
class StarWarsRemoteImpl(private val httpService: HttpServiceImpl) : StarWarsRemote {
    override suspend fun getMovie(): Movie {
        return httpService.getClient().get("https://swapi.dev/api/films/1/")
    }
}