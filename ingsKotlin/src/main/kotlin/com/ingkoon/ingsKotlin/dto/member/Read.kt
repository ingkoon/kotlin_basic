package com.ingkoon.ingsKotlin.dto.member

import com.ingkoon.ingsKotlin.domain.Member
import com.ingkoon.ingsKotlin.domain.enums.Grade
import javax.servlet.http.Cookie

class Read {
    data class Request(val id: Long){}

    data class LoginRequestByCookie(val cookie : Cookie)
    data class LoginRequestById(val name: String, val password: String)


    data class LoginResponseById(val cookie: Cookie)
    data class Response(val name: String, val grade: Grade){
        fun fromEntity(member: Member): Response{
            return Response(member.name, member.grade)
        }
    }
}