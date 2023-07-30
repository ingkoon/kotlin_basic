package com.ingkoon.ingsKotlin.domain

import com.ingkoon.ingsKotlin.domain.enums.Grade
import javax.persistence.*

@Entity
class MemberV2(
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var password: String,
    @Column
    @Enumerated(value = EnumType.STRING)
    val grade: Grade
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun updateName(name: String){
        this.name = name
    }

    fun updatePassword(password:String){
        this.password = password
    }
}
