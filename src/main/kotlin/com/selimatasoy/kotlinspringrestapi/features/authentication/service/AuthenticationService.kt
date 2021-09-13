package com.selimatasoy.kotlinspringrestapi.features.authentication.service

import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginResponseDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import org.springframework.security.core.userdetails.UserDetailsService

interface AuthenticationService : UserDetailsService {
    fun login(request: LoginRequestDto): LoginResponseDto
    fun getUserInfo(email: String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto)
}