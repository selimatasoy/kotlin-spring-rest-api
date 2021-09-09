package com.selimatasoy.kotlinspringrestapi.features.authentication.controller

import com.selimatasoy.kotlinspringrestapi.features.authentication.data.AuthenticationData
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginResponseDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@RestController
class AuthenticationController constructor(private val authenticationData: AuthenticationData) {

    @PostMapping("/createUser/")
    fun createUser(@RequestBody body:UserInfoDto) {
        authenticationData.createUser(body)
        return
    }

    @PostMapping("/login/")
    fun login(@RequestBody body:LoginRequestDto): LoginResponseDto {
        return authenticationData.login(body)
    }

    @GetMapping("/userInfo/")
    fun getUserInfo(@RequestParam email:String):UserInfoDto {
        return authenticationData.getUserInfo(email)
    }

}