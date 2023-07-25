package com.ingkoon.ingsKotlin.domain.enums

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Diary(
    @Column(nullable = false)
    val createAt: LocalDateTime,
    @Column(nullable = false, length = 512)
    val content: String,
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}