package com.ingkoon.ingsKotlin.controller

import com.ingkoon.ingsKotlin.dto.member.Create
import com.ingkoon.ingsKotlin.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController{

    @Autowired
    lateinit var memberService: MemberService

    @PostMapping
    fun createMember(@RequestBody requestDto: Create.request): ResponseEntity<Create.response>{
        val response = memberService
            .joinMember(requestDto);
        return ResponseEntity.ok().body(response);
    }
}