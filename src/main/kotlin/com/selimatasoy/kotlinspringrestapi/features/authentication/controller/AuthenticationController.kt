package com.selimatasoy.kotlinspringrestapi.features.authentication.controller

import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginResponseDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.service.AuthenticationService
import org.springframework.web.bind.annotation.*

@RestController
class AuthenticationController(val authenticationService: AuthenticationService) {

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
    fun getUserInfo(@RequestParam email: String): UserInfoDto {
        return authenticationService.getUserInfo(email)
    }

}