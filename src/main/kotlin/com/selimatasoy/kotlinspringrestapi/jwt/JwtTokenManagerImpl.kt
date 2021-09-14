package com.selimatasoy.kotlinspringrestapi.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service
import java.util.*


@Service
@Configuration
class JwtTokenManagerImpl : JwtTokenManager {

    @Value("\${jwt.secret}")
    private val secret: String? = null

    @Value("\${jwt.issuer}")
    private val issuer: String? = null

    @Value("\${jwt.validity_ms}")
    private val validityInMs: Long? = null

    override fun generateToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .setIssuer(issuer)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis().plus(validityInMs!!)))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact()
    }

    override fun tokenValidate(token: String): Boolean {
        return getUserFromToken(token) != null && !isExpired(token)
    }

    override fun isExpired(token: String): Boolean {
        return Jwts.parser().setSigningKey(secret)
            .parseClaimsJws(token).body.expiration.before(Date(System.currentTimeMillis()))
    }

    override fun getUserFromToken(token: String): String? {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body.subject
    }
}