package com.selimatasoy.kotlinspringrestapi.features.healthcheck.controller

import com.selimatasoy.kotlinspringrestapi.features.healthcheck.data.HealthCheckData
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HealthCheckController(private val healthCheckData:HealthCheckData) {

    @GetMapping("/healthCheck/")
    fun getHealthCheck(): String? {
        return healthCheckData.getHealthCheckStatus()
    }

}