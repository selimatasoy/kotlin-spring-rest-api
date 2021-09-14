package com.selimatasoy.kotlinspringrestapi.features.authentication.controller

import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginResponseDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.service.AuthenticationService
import com.selimatasoy.kotlinspringrestapi.jwt.JwtTokenManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException

@RestController
class AuthenticationController(val authenticationService: AuthenticationService) {

    @Autowired
    private lateinit var jwtTokenManager: JwtTokenManager

    @PostMapping("/api/v1/createUser")
    fun createUser(@RequestBody body: UserInfoDto) {
        authenticationService.createUser(body)
        return
    }

    @PostMapping("/api/v1/login")
    fun login(@RequestBody body: LoginRequestDto): LoginResponseDto {
        return authenticationService.login(body)
    }

    @GetMapping("/api/v1/userInfo")
    fun getUserInfo(@RequestHeader("Authorization") authorizationToken: String?): UserInfoDto {
        if (authorizationToken != null) {
            return authenticationService.getUserInfo(jwtTokenManager!!.getUserFromToken(authorizationToken!!.substring(7)))
        } else {
            throw HttpClientErrorException(HttpStatus.FORBIDDEN)
        }
    }

}