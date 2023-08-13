package com.ingkoon.ingsKotlin.common.filter

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ingkoon.ingsKotlin.common.exception.common.PreconditionFailedException
import com.ingkoon.ingsKotlin.dto.member.Create

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StreamUtils
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
        if(req.cookies != null) {
            chain?.doFilter(request, response)
            return
        }
        val wrapper = RequestWrapper(req)
        val body : ByteArray = StreamUtils.copyToByteArray(wrapper.inputStream)
        val requestDto: Any
        try{
            requestDto = mapper.readValue(body)
            log.info("정상적인 요청이 수행되었습니다.")
            chain?.doFilter(wrapper, response)
            return
        }catch (e: UnrecognizedPropertyException){
            throw PreconditionFailedException()
        }
    }
}