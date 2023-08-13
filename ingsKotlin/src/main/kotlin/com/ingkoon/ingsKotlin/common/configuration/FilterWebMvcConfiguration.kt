package com.ingkoon.ingsKotlin.common.configuration

import com.ingkoon.ingsKotlin.common.filter.CookieFilter
import com.ingkoon.ingsKotlin.common.filter.LoginFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.servlet.Filter

@Configuration
class FilterWebMvcConfiguration : WebMvcConfigurer{

    @Bean
    fun runFilterRegistration(){
        registryCookieFilter()
        registerLoginFilter()
    }

    @Bean
    fun registryCookieFilter() : FilterRegistrationBean<CookieFilter>{
        val registrationBean = FilterRegistrationBean(CookieFilter())
        registrationBean.order = 0
        registrationBean.urlPatterns = mutableListOf("/member/*")
        return registrationBean

    }

    @Bean
    fun registerLoginFilter() : FilterRegistrationBean<LoginFilter>{
        val registrationBean = FilterRegistrationBean(LoginFilter())
        registrationBean.order = 1
        registrationBean.urlPatterns = mutableListOf("/member/*")
        return registrationBean
    }


}