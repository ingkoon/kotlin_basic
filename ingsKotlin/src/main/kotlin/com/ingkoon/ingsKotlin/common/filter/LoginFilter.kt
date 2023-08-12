package com.ingkoon.ingsKotlin.common.filter

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ingkoon.ingsKotlin.common.exception.common.PreconditionFailedException
import com.ingkoon.ingsKotlin.dto.member.Create

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

@Component
class LoginFilter : Filter {

    private val log = LoggerFactory.getLogger(javaClass)
    private val mapper  = jacksonObjectMapper()

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val req : HttpServletRequest = request as HttpServletRequest
        val json : String = req.inputStream.bufferedReader().use { it.readText()}
        val requestDto: Create.request
        try{
            requestDto = mapper.readValue(json)
        }catch (e: UnrecognizedPropertyException){
            throw PreconditionFailedException()
        }

        log.info("정상적인 요청이 수행되었습니다.")
    }
}