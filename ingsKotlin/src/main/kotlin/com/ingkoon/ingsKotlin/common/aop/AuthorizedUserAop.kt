package com.ingkoon.ingsKotlin.common.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class AuthorizedUserAop {
    private val log = LoggerFactory.getLogger(javaClass)
    @Around("@annotation(com.ingkoon.ingsKotlin.common.annotation.AuthorizedValue)")
    fun getData(joinPoint: ProceedingJoinPoint, ){
        joinPoint.proceed()
    }
}
