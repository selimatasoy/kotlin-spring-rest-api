package com.selimatasoy.kotlinspringrestapi.features.starwars.controller

import com.selimatasoy.kotlinspringrestapi.features.starwars.model.Movie
import com.selimatasoy.kotlinspringrestapi.features.starwars.service.StarWarsService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(value = "StarWars Controller")
class StarWarsController(private val starWarsService: StarWarsService) {

    @GetMapping("/api/v1/movie")
    @ApiOperation(value = "returns an info of a star wars movie from an external api")
    suspend fun getMovie(): Movie? {
        return starWarsService.getMovie()
    }

}