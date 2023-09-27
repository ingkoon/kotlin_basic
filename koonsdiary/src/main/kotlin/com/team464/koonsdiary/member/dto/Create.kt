package com.team464.koonsdiary.member.dto

import com.team464.koonsdiary.image.domain.Image
import com.team464.koonsdiary.member.domain.Member

class Create{
    data class Request(
        val account: String,
        val email: String,
        val nickname: String,
        val image: String
    ){
        fun toEntity(image: Image): Member {
            return Member(account, email, nickname, image)
        }
    }
}
