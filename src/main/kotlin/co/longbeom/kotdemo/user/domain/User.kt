package co.longbeom.kotdemo.user.domain

import co.longbeom.kotdemo.user.type.LoginType
import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: String? = null,
        val socialId: String? = null,
        @Enumerated(value = EnumType.STRING)
        val loginType: LoginType? = null,
        val nickname: String,
        var email: String
)