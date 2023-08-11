package com.ingkoon.ingsKotlin.common.configuration

import com.ingkoon.ingsKotlin.common.filter.CookieFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class FilterWebMvcConfiguration : WebMvcConfigurer{

    @Bean
    fun registryCookieFilter() : FilterRegistrationBean<CookieFilter>{
        val registrationBean = FilterRegistrationBean(CookieFilter())
        registrationBean.order = 0
        registrationBean.urlPatterns = mutableListOf("/*")
        return registrationBean

    }
}