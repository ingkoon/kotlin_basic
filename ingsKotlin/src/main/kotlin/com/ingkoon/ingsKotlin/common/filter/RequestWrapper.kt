package com.ingkoon.ingsKotlin.common.filter

import org.springframework.util.StreamUtils
import javax.servlet.ServletInputStream
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper

class RequestWrapper(request: HttpServletRequest) : HttpServletRequestWrapper(request) {

    private lateinit var body : ByteArray

    init {
        this.body = StreamUtils.copyToByteArray(request.inputStream)
    }

    override fun getInputStream(): ServletInputStream {
        return ServletInputStreamWrapper(this.body)
    }

}