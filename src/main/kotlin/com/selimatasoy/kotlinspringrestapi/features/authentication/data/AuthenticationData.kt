package com.selimatasoy.kotlinspringrestapi.features.authentication.data

import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginResponseDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

interface AuthenticationData {
    fun login(request: LoginRequestDto): LoginResponseDto
    fun getUserInfo(email:String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto)
}