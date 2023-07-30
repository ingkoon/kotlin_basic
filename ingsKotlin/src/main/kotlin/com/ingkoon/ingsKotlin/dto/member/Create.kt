package com.ingkoon.ingsKotlin.dto.member

import com.ingkoon.ingsKotlin.domain.Member
import com.ingkoon.ingsKotlin.domain.enums.Grade

class Create {
    data class request(val name: String, val password: String, val grade: Grade){
        fun toEntity(): Member{
            return Member(name, password, grade)
        }

    }

    data class response(val message: String)

}