package com.ingkoon.ingsKotlin.controller

import com.ingkoon.ingsKotlin.dto.member.Create
import com.ingkoon.ingsKotlin.dto.member.Read
import com.ingkoon.ingsKotlin.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController{

    @Autowired
    lateinit var memberService: MemberService

    @PostMapping
    fun createMember(@RequestBody requestDto: Create.request): ResponseEntity<Create.response>{
        val response = memberService
            .joinMember(requestDto)
        return ResponseEntity.ok().body(response)
    }

    @PostMapping("/login")
    fun loginMember(@RequestBody requestDto: Read.LoginRequestById) : ResponseEntity<String>{
        val response = memberService.loginMember(requestDto)
        return ResponseEntity
            .ok()
            .header(HttpHeaders.SET_COOKIE, response.cookie.toString())
            .body("성공적으로 로그인 되었습니다.")
    }

    @GetMapping
    fun getMembers(@RequestParam id : Long) : ResponseEntity<Read.Response>{
        val requestDto : Read.Request = Read.Request(id)
        val response : Read.Response = memberService.readMember(requestDto)
        return ResponseEntity
            .ok()
            .body(response)
    }
}