package com.selimatasoy.kotlinspringrestapi.features.healthcheck.data

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class HealthCheckDataImpl : HealthCheckData {
    override fun getHealthCheckStatus(): String {
        return "Healthy"
    }
}