package com.selimatasoy.kotlinspringrestapi.features.healthcheck.controller

import com.selimatasoy.kotlinspringrestapi.features.healthcheck.service.HealthCheckService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@Api(value = "HealthCheck Controller")
class HealthCheckController(val healthCheckService: HealthCheckService) {

    @GetMapping("/public-api/v1/healthCheck")
    @ApiOperation(value = "returns a simple string for the sake of the example")
    fun getHealthCheck(): String? {
        return healthCheckService.getHealthCheckStatus()
    }

}