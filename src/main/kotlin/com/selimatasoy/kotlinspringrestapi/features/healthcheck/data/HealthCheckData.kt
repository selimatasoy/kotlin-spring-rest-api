package com.selimatasoy.kotlinspringrestapi.features.healthcheck.data

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

interface HealthCheckData {
    fun getHealthCheckStatus():String
}