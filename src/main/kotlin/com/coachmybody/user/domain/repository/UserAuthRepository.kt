package com.coachmybody.user.domain.repository

import com.coachmybody.user.domain.UserAuth
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserAuthRepository : JpaRepository<UserAuth, Long> {
    fun findByUserId(userId: UUID): Optional<UserAuth>
}