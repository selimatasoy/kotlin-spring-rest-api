package com.selimatasoy.kotlinspringrestapi.features.healthcheck.controller

import com.selimatasoy.kotlinspringrestapi.features.healthcheck.service.HealthCheckService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HealthCheckController(val healthCheckService: HealthCheckService) {

    @GetMapping("/api/v1/healthCheck")
    fun getHealthCheck(): String? {
        return healthCheckService.getHealthCheckStatus()
    }

}