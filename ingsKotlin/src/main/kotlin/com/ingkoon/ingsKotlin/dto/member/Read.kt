package com.ingkoon.ingsKotlin.dto.member

import com.ingkoon.ingsKotlin.domain.Member
import com.ingkoon.ingsKotlin.domain.enums.Grade
import javax.servlet.http.Cookie

class Read {
    data class request(val id: Long)

    data class LoginRequestByCookie(val cookie : Cookie)
    data class LoginRequestById(val id: String, val password: String)

    data class response(val name: String, val grade: Grade){
        fun fromEntity(member: Member): response{
            return response(member.name, member.grade)
        }
    }
}