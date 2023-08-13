package com.ingkoon.ingsKotlin.service

import com.ingkoon.ingsKotlin.common.annotation.TimeLog
import com.ingkoon.ingsKotlin.common.exception.common.PreconditionFailedException
import com.ingkoon.ingsKotlin.domain.Member
import com.ingkoon.ingsKotlin.dto.member.Create
import com.ingkoon.ingsKotlin.dto.member.Read

import com.ingkoon.ingsKotlin.repository.MemberRepository
import com.ingkoon.ingsKotlin.utils.cookie.CookieConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException
import javax.servlet.http.Cookie

@Service
@Transactional(readOnly = true)
class MemberService {

    @Autowired
    lateinit var memberRepository: MemberRepository
    @Autowired
    lateinit var cookieConfiguration: CookieConfiguration

    @TimeLog
    @Transactional
    fun joinMember(requestDto: Create.request):
            Create.response {
        val member: Member = requestDto.toEntity()
        memberRepository.save(member)
        return Create.response("성공적으로 저장되었습니다.")
    }

    fun loginMemberByCookie(requestDto: Read.LoginRequestByCookie){
        val cookie : Cookie = requestDto.cookie

    }
    fun loginMember(requestDto: Read.LoginRequestById) : Read.LoginResponseById{
        val name : String = requestDto.name
        val password: String = requestDto.password

        val member: Member = memberRepository.findByNameAndPassword(name, password)
        val cookie : Cookie = cookieConfiguration.createCookie(name, password, "localhost")

        val response : Read.LoginResponseById = Read.LoginResponseById(cookie)

        return response
    }

    fun readMember(requestDto: Read.Request): Read.Response {
        val memberId: Long = requestDto.id
        val member: Member = memberRepository.findById(memberId).orElseThrow()
        return Read.Response(member.name, member.grade)
    }
}