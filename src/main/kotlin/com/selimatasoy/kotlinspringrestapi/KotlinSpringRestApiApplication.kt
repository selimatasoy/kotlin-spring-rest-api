package com.selimatasoy.kotlinspringrestapi

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
class KotlinSpringRestApiApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringRestApiApplication>(*args)
}
