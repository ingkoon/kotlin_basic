package com.ingkoon.ingsKotlin.domain

import com.ingkoon.ingsKotlin.domain.enums.Grade
import javax.persistence.*
// 테스트용 주석 추가
@Entity
class Member(
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var password: String,
    @Column
    @Enumerated(value = EnumType.STRING)
    val grade: Grade
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun updateName(name: String){
        this.name = name
    }

    fun updatePassword(password:String){
        this.password = password
    }
}
