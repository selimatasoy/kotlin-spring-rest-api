package com.selimatasoy.kotlinspringrestapi.features.authentication.dao

import com.selimatasoy.kotlinspringrestapi.extensions.connectToExampleDatabase
import com.selimatasoy.kotlinspringrestapi.features.authentication.dao.entity.User
import com.selimatasoy.kotlinspringrestapi.features.authentication.dao.mapper.fromUserDaoToUserInfo
import com.selimatasoy.kotlinspringrestapi.features.authentication.model.UserInfoDto
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class AuthenticationDaoImpl() : AuthenticationDao {

    @Autowired
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    override fun login(username: String): UserDetails {
        Database.connectToExampleDatabase()

        val userInfo = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction User.select { User.email eq username }.single().fromUserDaoToUserInfo()
        }
        return org.springframework.security.core.userdetails.User(userInfo.email, userInfo.password, ArrayList())
    }

    override fun getUserInfo(email: String): UserInfoDto {
        Database.connectToExampleDatabase()

        val userInfo = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction User.select { User.email eq email }.single().fromUserDaoToUserInfo()
        }
        return userInfo
    }

    override fun createUser(userInfoDto: UserInfoDto) {
        Database.connectToExampleDatabase()

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(User)
            User.insert {
                it[name] = userInfoDto.name
                it[surname] = userInfoDto.surname
                it[email] = userInfoDto.email
                it[password] = bCryptPasswordEncoder.encode(userInfoDto.password)
            }
        }
    }
}