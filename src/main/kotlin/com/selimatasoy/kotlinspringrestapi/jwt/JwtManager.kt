package com.selimatasoy.kotlinspringrestapi.jwt

import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import io.jsonwebtoken.Claims
import org.springframework.stereotype.Component

interface JwtManager {
    fun generateToken(loginRequestDto: LoginRequestDto): String
    fun getAllClaimsFromToken(token: String?): Claims
    fun isTokenExpired(token: String?): Boolean
    fun validateToken(token: String?, loginRequestDto: LoginRequestDto): Boolean
}