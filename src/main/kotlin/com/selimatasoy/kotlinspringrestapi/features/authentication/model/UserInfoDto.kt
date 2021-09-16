package com.selimatasoy.kotlinspringrestapi.features.authentication.model

import io.swagger.annotations.ApiModel

@ApiModel
data class UserInfoDto(val name: String, val surname: String, val email: String, var password: String?)