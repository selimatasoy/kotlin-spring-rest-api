package com.selimatasoy.kotlinspringrestapi.features.authentication.model

data class UserInfoDto(val name: String, val surname: String, val email: String, var password: String?)