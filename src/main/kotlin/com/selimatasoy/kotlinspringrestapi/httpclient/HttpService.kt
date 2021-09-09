package com.selimatasoy.kotlinspringrestapi.httpclient

import io.ktor.client.*
import org.springframework.stereotype.Component

interface HttpService {
    fun getClient(): HttpClient
}