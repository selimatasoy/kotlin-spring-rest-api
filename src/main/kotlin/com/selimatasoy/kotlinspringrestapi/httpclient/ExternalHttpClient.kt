package com.selimatasoy.kotlinspringrestapi.httpclient

import io.ktor.client.*

interface ExternalHttpClient {
    fun getClient(): HttpClient
}