package com.selimatasoy.kotlinspringrestapi.features.starwars.controller

import com.selimatasoy.features.starwars.model.Movie
import com.selimatasoy.kotlinspringrestapi.features.starwars.service.StarWarsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StarWarsController(private val starWarsService: StarWarsService) {

    @GetMapping("/api/v1/movie")
    suspend fun getMovie(): Movie? {
        return starWarsService.getMovie()
    }

}