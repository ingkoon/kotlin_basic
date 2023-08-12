package com.ingkoon.ingsKotlin.common.filter

import com.ingkoon.ingsKotlin.common.annotation.TimeLog
import com.mysql.cj.xdevapi.JsonParser
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.io.InputStream
import javax.servlet.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest

@Component
class CookieFilter : Filter {

    private val log = LoggerFactory.getLogger(javaClass)

    @TimeLog
    override fun init(filterConfig: FilterConfig?) {
        log.info("registered CookieFilter")
        super.init(filterConfig)
    }

    @TimeLog
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val req : HttpServletRequest = request as HttpServletRequest
        if(req.cookies == null){
            chain?.doFilter(request, response)
            return
        }
        val cookies : Array<Cookie> = req.cookies
        log.info(cookies.toString())
    }

    @TimeLog
    override fun destroy() {
        super.destroy()
    }
}