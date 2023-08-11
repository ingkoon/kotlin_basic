package com.ingkoon.ingsKotlin.service

import com.ingkoon.ingsKotlin.common.annotation.TimeLog
import com.ingkoon.ingsKotlin.domain.Member
import com.ingkoon.ingsKotlin.dto.member.Create
import com.ingkoon.ingsKotlin.dto.member.Read

import com.ingkoon.ingsKotlin.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.servlet.http.Cookie

@Service
@Transactional(readOnly = true)
class MemberService {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @TimeLog
    @Transactional
    fun joinMember(requestDto: Create.request):
            Create.response {
        var member: Member = requestDto.toEntity()
        memberRepository.save(member)
        return Create.response("성공적으로 저장되었습니다.")
    }

    fun loginMemberByCookie(requestDto: Read.LoginRequestByCookie){
        val cookie : Cookie = requestDto.cookie

    }
    fun loginMember(requestDto: Read.LoginRequestById){

    }

    fun readMember(requestDto: Read.request): Read.response {
        val memberId: Long = requestDto.id
        val member: Member = memberRepository.findById(memberId).orElseThrow()
        return Read.response(member.name, member.grade)
    }
}