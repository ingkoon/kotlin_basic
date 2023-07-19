package com.ingkoon.ingsKotlin.dto.member

import com.ingkoon.ingsKotlin.domain.Member
import com.ingkoon.ingsKotlin.domain.enums.Grade

class Create {
    data class request(val name: String, val grade: Grade){
        fun toEntity(): Member{
            return Member(name, grade)
        }

    }

    data class response(val message: String)

}