package co.longbeom.kotdemo.user.domain

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class UserAuth(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val accessToken: String,
        val refreshToken: String,
        val expiredAt: Instant
)