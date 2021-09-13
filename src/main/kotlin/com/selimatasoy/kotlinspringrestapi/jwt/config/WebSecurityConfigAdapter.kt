package com.selimatasoy.kotlinspringrestapi.jwt.config

import com.selimatasoy.kotlinspringrestapi.jwt.JwtTokenFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Component
class WebSecurityConfigAdapter : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var jwtTokenFilter: JwtTokenFilter

    @Autowired
    private lateinit var userDetailsService: UserDetailsService

    @Autowired
    fun configurePasswordEncoder(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(getBCryptPasswordEncoder())
    }

    @Bean
    fun getBCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/v1/login")
            .authenticated()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/v1/createUser").permitAll()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager? {
        return super.authenticationManagerBean()
    }
}