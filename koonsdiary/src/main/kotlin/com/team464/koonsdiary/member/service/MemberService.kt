package com.team464.koonsdiary.member.service

import com.team464.koonsdiary.member.dto.Create

interface MemberService {
    fun create(createRequest: Create.Request)
    fun read()
}