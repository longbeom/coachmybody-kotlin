package com.coachmybody.user.domain

import com.coachmybody.user.type.LoginType
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @field:Type(type = "uuid-char")
        val id: UUID,
        @Column(unique = true)
        val socialId: String,
        @Enumerated(value = EnumType.STRING)
        val loginType: LoginType,
        var nickname: String,
        var email: String
)