package com.selimatasoy.kotlinspringrestapi.features.healthcheck.service

interface HealthCheckService {
    fun getHealthCheckStatus(): String
}