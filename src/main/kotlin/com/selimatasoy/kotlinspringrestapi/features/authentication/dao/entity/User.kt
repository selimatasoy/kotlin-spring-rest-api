package com.selimatasoy.kotlinspringrestapi.features.authentication.dao.entity

import org.jetbrains.exposed.sql.Table

object User : Table("user") {
    val name = varchar("Name", 50)
    val surname = varchar("Surname",50)
    val email = varchar("Email", 50)
    val password = varchar("Password", 200)

    override val primaryKey = PrimaryKey(email)
}