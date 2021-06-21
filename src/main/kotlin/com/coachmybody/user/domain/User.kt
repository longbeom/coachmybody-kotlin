package com.coachmybody.user.domain

import com.coachmybody.user.type.LoginType
import java.util.*
import javax.persistence.*

@Entity
data class User(
        @Id
        @Column(name = "id", unique = true, nullable = false)
        val id: UUID,
        @Column(unique = true, nullable = false)
        val socialId: String,
        @Enumerated(value = EnumType.STRING)
        val loginType: LoginType,
        var nickname: String,
        val email: String
)