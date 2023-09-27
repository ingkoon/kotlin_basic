package com.team464.koonsdiary.member.domain

import com.team464.koonsdiary.image.domain.Image
import javax.persistence.*

@Entity
@Table(name = "members")
class Member (
    @Column(length = 16, unique = true)
    val account: String,
    @Column(length = 12)
    var nickname: String,
    @Column(length = 32, unique = true)
    val email: String,
    @OneToOne(fetch = FetchType.LAZY)
    var image: Image
    ){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun updateNickname(nickname: String){
        this.nickname = nickname
    }
    fun updateImage(image: Image){
        this.image = image
    }
}