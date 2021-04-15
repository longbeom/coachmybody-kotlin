package co.longbeom.kotdemo.user.domain

import co.longbeom.kotdemo.user.type.LoginType
import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: String,
        val socialId: String,
        @Enumerated(value = EnumType.STRING)
        val loginType: LoginType,
        var nickname: String,
        var email: String
)