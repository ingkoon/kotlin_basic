package com.ingkoon.ingsKotlin.domain

import com.ingkoon.ingsKotlin.domain.enums.Grade
import javax.persistence.*

@Entity
class Member(
    @Column
    var name: String,
    @Column
    @Enumerated(value = EnumType.STRING)
    val grade: Grade
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun updateName(name: String){
        this.name = name
    }
}
