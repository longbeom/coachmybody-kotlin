package com.coachmybody.user.domain.repository

import com.coachmybody.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, UUID> {
    fun findBySocialId(socialId: String): Optional<User>
}