package com.selimatasoy.kotlinspringrestapi.features.starwars.controller

import com.selimatasoy.kotlinspringrestapi.features.starwars.data.StarWarsData
import com.selimatasoy.features.starwars.model.Movie
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StarWarsController(private val starWarsData: StarWarsData) {

    @GetMapping("/movie/")
    suspend fun getMovie(): Movie? {
        return starWarsData.getMovie()
    }

}