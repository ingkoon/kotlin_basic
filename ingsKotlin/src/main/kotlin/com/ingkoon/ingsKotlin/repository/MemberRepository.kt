package com.ingkoon.ingsKotlin.repository

import com.ingkoon.ingsKotlin.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: JpaRepository<Member, Long>{
}