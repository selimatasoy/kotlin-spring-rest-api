package com.selimatasoy.kotlinspringrestapi.features.authentication.dao

import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import org.springframework.security.core.userdetails.UserDetails

interface AuthenticationDao {
    fun login(username: String): UserDetails
    fun getUserInfo(email: String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto)
}