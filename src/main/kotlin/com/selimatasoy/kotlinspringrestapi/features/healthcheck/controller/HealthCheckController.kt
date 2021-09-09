package com.selimatasoy.kotlinspringrestapi.features.healthcheck.controller

import com.selimatasoy.kotlinspringrestapi.features.healthcheck.service.HealthCheckService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HealthCheckController(private val healthCheckService: HealthCheckService) {

    @GetMapping("/healthCheck/")
    fun getHealthCheck(): String? {
        return healthCheckService.getHealthCheckStatus()
    }

}