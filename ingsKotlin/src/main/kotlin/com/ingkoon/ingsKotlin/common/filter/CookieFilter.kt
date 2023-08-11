package com.ingkoon.ingsKotlin.common.filter

import com.ingkoon.ingsKotlin.common.annotation.TimeLog
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.servlet.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest

@Component
class CookieFilter : Filter {

    private val log = LoggerFactory.getLogger(javaClass)

    @TimeLog
    override fun init(filterConfig: FilterConfig?) {
        log.info("쿠키 확인을 시작합니다.")
        super.init(filterConfig)
    }

    @TimeLog
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val req : HttpServletRequest = request as HttpServletRequest
        log.info(req.inputStream.bufferedReader().use { it.readText() })

//        val cookies : Array<Cookie> = req.cookies
//        log.info(cookies.toString())
        chain?.doFilter(request, response)
    }

    @TimeLog
    override fun destroy() {
        super.destroy()
    }
}