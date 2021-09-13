package com.selimatasoy.kotlinspringrestapi.jwt

interface JwtTokenManager {
    fun generateToken(username: String): String
    fun tokenValidate(token: String): Boolean
    fun getUserFromToken(token: String): String?
    fun isExpired(token: String): Boolean
}