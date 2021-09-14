package com.selimatasoy.kotlinspringrestapi.jwt

import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtTokenFilter(val tokenManager: JwtTokenManager) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        var authHeader: String? = null
        var token: String? = null
        var userName: String? = null

        try {
            authHeader = request.getHeader("Authorization")
            if (authHeader != null && authHeader.contains("Bearer")) {
                token = authHeader.substring(7)
                userName = tokenManager.getUserFromToken(token!!)
            }
        } catch (e: Exception) {
            throw HttpClientErrorException(HttpStatus.FORBIDDEN)
        }
        if (userName != null && token != null && SecurityContextHolder.getContext().authentication == null) {
            if (tokenManager.tokenValidate(token)) {
                val usernamePasswordAuthenticationToken =
                    UsernamePasswordAuthenticationToken(userName, null, ArrayList())
                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            }
        }

        filterChain.doFilter(request, response)

    }
}