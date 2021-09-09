package com.selimatasoy.kotlinspringrestapi.features.authentication.service

import com.selimatasoy.kotlinspringrestapi.features.authentication.dao.AuthenticationDao
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginResponseDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import com.selimatasoy.kotlinspringrestapi.jwt.JwtManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthenticationServiceImpl @Autowired constructor(
    private val authenticationDao: AuthenticationDao,
    private val jwtManager: JwtManager
) :
    AuthenticationService {
    override fun login(request: LoginRequestDto): LoginResponseDto {
        if (authenticationDao.login(request)) {
            return LoginResponseDto("will return a jwt token soon")//TODO
        } else {
            throw Exception("There is no such user")
        }
    }

    override fun getUserInfo(email: String): UserInfoDto {
        return authenticationDao.getUserInfo(email)
    }

    override fun createUser(userInfoDto: UserInfoDto) {
        return authenticationDao.createUser(userInfoDto)
    }
}