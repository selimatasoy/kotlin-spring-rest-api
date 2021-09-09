package com.selimatasoy.kotlinspringrestapi.jwt

import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.io.Serializable
import java.util.*
import kotlin.collections.HashMap

@Component
@Configuration
class JwtManagerImpl : Serializable, JwtManager {
    @Value("\${jwt.secret}")
    private val secret: String? = null

    @Value("\${jwt.validity_ms}")
    private val validityInMs: String? = null

    @Value("\${jwt.subject}")
    private val subject: String? = null

    override fun getAllClaimsFromToken(token: String?): Claims {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
    }

    override fun isTokenExpired(token: String?): Boolean {
        val claims:Claims = getAllClaimsFromToken(token)
        return claims.expiration.before(Date())
    }

    override fun generateToken(loginRequestDto: LoginRequestDto): String {
        val claims: MutableMap<String, Any> = HashMap()
        claims["email"] = loginRequestDto.username
        return Jwts
            .builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + validityInMs!!.toLong()))
            .signWith(SignatureAlgorithm.HS512, secret).compact()
    }

    override fun validateToken(token: String?, loginRequestDto: LoginRequestDto): Boolean {
        val claims:Claims = getAllClaimsFromToken(token)
        return loginRequestDto.username == claims["email"] && !isTokenExpired(token)
    }
}