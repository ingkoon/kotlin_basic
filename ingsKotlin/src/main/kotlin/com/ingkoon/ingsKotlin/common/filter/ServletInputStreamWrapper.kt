package com.ingkoon.ingsKotlin.common.filter

import java.io.ByteArrayInputStream
import java.io.InputStream
import javax.servlet.ReadListener
import javax.servlet.ServletInputStream

class ServletInputStreamWrapper(body: ByteArray) : ServletInputStream() {

    private var inputStream : InputStream? = null

    init {
        this.inputStream = ByteArrayInputStream(body)
    }

    override fun read(): Int {
        return inputStream?.read()!!
    }

    override fun isFinished(): Boolean {
        return try{
            inputStream?.available() == 0
        } catch (exception : Exception){
            false
        }
    }

    override fun isReady(): Boolean {
        return true
    }

    override fun setReadListener(listener: ReadListener?) {
    }
}