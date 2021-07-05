package com.coachmybody.user.domain

import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*
import javax.persistence.*

@Entity
data class UserAuth(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        val id: Long? = null,
        val userId: UUID,
        var accessToken: String,
        var refreshToken: String,
        var expiredAt: Instant,
) {
    companion object {
        fun newAuth(userId: UUID): UserAuth {
            var now = Instant.now()
            return UserAuth(
                    userId = userId,
                    accessToken = UUID.randomUUID().toString(),
                    refreshToken = UUID.randomUUID().toString(),
                    expiredAt = Instant.now().plus(1, ChronoUnit.DAYS)
            )
        }
    }

    fun refresh() {
        this.accessToken = UUID.randomUUID().toString()
        this.expiredAt = Instant.now().plus(1, ChronoUnit.DAYS)
    }
}