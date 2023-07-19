package com.ingkoon.ingsKotlin.service

import com.ingkoon.ingsKotlin.domain.Member
import com.ingkoon.ingsKotlin.dto.member.Create
import com.ingkoon.ingsKotlin.dto.member.Read

import com.ingkoon.ingsKotlin.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService {

    lateinit var memberRepository: MemberRepository

    @Transactional
    fun joinMember(requestDto: Create.request):
            Create.response {
        var member: Member = requestDto.toEntity()
        memberRepository.save(member)
        return Create.response("성공적으로 저장되었습니다.")
    }

    fun readMember(requestDto: Read.request): Read.response {
        var memberId: Long = requestDto.id
        val member: Member = memberRepository.findById(memberId).orElseThrow()
        return Read.response(member.name, member.grade)
    }
}