package com.selimatasoy.kotlinspringrestapi.features.authentication.controller

import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginResponseDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.service.AuthenticationService
import com.selimatasoy.kotlinspringrestapi.jwt.JwtTokenManager
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException

@RestController
@Api(value = "Authentication Controller")
class AuthenticationController(val authenticationService: AuthenticationService) {

    @Autowired
    private lateinit var jwtTokenManager: JwtTokenManager

    @PostMapping("/public-api/v1/authentication/createUser")
    @ApiOperation(value = "Creates a User")
    fun createUser(@RequestBody body: UserInfoDto) {
        authenticationService.createUser(body)
        return
    }

    @PostMapping("/public-api/v1/authentication/login")
    @ApiOperation(value = "Login service")
    fun login(@RequestBody body: LoginRequestDto): LoginResponseDto {
        return authenticationService.login(body)
    }

    @GetMapping("/api/v1/authentication/userInfo")
    @ApiOperation(value = "Gets userInfo ")
    fun getUserInfo(@RequestHeader("Authorization") authorizationToken: String?): UserInfoDto {
        if (authorizationToken != null) {
            return authenticationService.getUserInfo(jwtTokenManager.getUserFromTokenWithBearer(authorizationToken))
        } else {
            throw HttpClientErrorException(HttpStatus.FORBIDDEN)
        }
    }

}