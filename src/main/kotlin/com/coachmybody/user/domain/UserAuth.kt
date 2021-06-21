package com.coachmybody.user.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class UserAuth(
        @Id
        @Column(name = "id", unique = true, nullable = false)
        val id: Long? = null,
        var accessToken: String,
        var refreshToken: String,
        var expiredAt: Instant
)