package com.ingkoon.ingsKotlin.domain.enums

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TestServlet : HttpServlet() {
    override fun init() {
        super.init()
        this.toString()
    }

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        super.service(req, resp)
    }

    override fun destroy() {
        super.destroy()
    }
}