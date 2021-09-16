package com.selimatasoy.kotlinspringrestapi.features.authentication.model

import io.swagger.annotations.ApiModel

@ApiModel
data class LoginRequestDto(val username: String, val password: String)