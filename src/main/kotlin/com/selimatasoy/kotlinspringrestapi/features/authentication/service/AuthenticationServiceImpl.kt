package com.selimatasoy.kotlinspringrestapi.features.authentication.service

import com.selimatasoy.kotlinspringrestapi.features.authentication.dao.AuthenticationDao
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginRequestDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.LoginResponseDto
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import com.selimatasoy.kotlinspringrestapi.jwt.JwtTokenManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthenticationServiceImpl :
    AuthenticationService {

    @Autowired
    private lateinit var jwtTokenManager: JwtTokenManager

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var authenticationDao: AuthenticationDao

    override fun login(request: LoginRequestDto): LoginResponseDto {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.username, request.password))
        return LoginResponseDto(jwtTokenManager.generateToken(request.username))
    }

    override fun getUserInfo(email: String): UserInfoDto {
        return authenticationDao.getUserInfo(email).apply { password = null }
    }

    override fun createUser(userInfoDto: UserInfoDto) {
        return authenticationDao.createUser(userInfoDto)
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return authenticationDao.login(username)
    }
}