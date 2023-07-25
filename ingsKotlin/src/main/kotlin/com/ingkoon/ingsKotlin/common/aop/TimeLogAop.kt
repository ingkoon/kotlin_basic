package com.ingkoon.ingsKotlin.common.aop


import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class TimeLogAop {
    private val log = LoggerFactory.getLogger(javaClass)
    @Around("@annotation(com.ingkoon.ingsKotlin.common.annotation.TimeLog)")
    fun printBeforeTimeLog(joinPoint: ProceedingJoinPoint){
        val startTime = System.currentTimeMillis()
        joinPoint.proceed()
        val endTime = System.currentTimeMillis()
        log.info("${joinPoint.signature.name}의 api 호출 시간은 ${(endTime - startTime)}ms 입니다 \n")
    }
}