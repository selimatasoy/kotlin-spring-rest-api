package com.selimatasoy.kotlinspringrestapi.features.healthcheck.service

import org.springframework.stereotype.Service

@Service
class HealthCheckServiceImpl : HealthCheckService {
    override fun getHealthCheckStatus(): String {
        return "Healthy"
    }
}