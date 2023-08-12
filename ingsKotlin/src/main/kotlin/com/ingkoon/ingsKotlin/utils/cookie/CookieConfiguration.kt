package com.ingkoon.ingsKotlin.utils.cookie

import org.springframework.stereotype.Component
import javax.servlet.http.Cookie

@Component
class CookieConfiguration {
    private val MAX_AGE : Int = 60 * 60
    fun createCookie(id: String, password: String, domain: String): Cookie {
        val cookie : Cookie = Cookie(id, password)
        cookie.domain = "localhost"
        cookie.path = "/"
        cookie.maxAge = MAX_AGE
        cookie.secure = true
        return cookie
    }
}