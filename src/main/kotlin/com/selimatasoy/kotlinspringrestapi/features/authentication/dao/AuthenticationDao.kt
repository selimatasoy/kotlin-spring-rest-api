package com.selimatasoy.kotlinspringrestapi.features.authentication.dao

import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import org.springframework.stereotype.Repository

interface AuthenticationDao {
    fun login(request: LoginRequestDto): Boolean
    fun getUserInfo(email:String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto)
}