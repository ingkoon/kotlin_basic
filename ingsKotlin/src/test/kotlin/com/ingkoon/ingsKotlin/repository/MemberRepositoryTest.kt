package com.ingkoon.ingsKotlin.repository

import com.ingkoon.ingsKotlin.domain.Member
import com.ingkoon.ingsKotlin.domain.enums.Grade
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    lateinit var memberrepository: MemberRepository

    @Test
    @DisplayName(value = "회원 생성")
    fun createMember(){
        val firstMember: Member = Member("first", Grade.MEMBER)
        val secondMember: Member = Member("second", Grade.MEMBER)

        val member1 = memberrepository.save(firstMember)
        val member2 = memberrepository.save(secondMember)

        print(1)
        print("${firstMember.hashCode()} and ${secondMember.hashCode()}\n")

    }
}