package com.selimatasoy.kotlinspringrestapi.features.authentication.controller

import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginResponseDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.service.AuthenticationService
import org.springframework.web.bind.annotation.*

@RestController
class AuthenticationController constructor(private val authenticationService: AuthenticationService) {

    @PostMapping("/createUser/")
    fun createUser(@RequestBody body: UserInfoDto) {
        authenticationService.createUser(body)
        return
    }

    @PostMapping("/login/")
    fun login(@RequestBody body: LoginRequestDto): LoginResponseDto {
        return authenticationService.login(body)
    }

    @GetMapping("/userInfo/")
    fun getUserInfo(@RequestParam email:String):UserInfoDto {
        return authenticationService.getUserInfo(email)
    }

}