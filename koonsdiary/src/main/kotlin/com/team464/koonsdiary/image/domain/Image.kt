package com.team464.koonsdiary.image.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Image(val imagePath: String) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null
}