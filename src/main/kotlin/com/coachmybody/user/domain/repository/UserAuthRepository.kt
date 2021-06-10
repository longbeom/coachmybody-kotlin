package com.coachmybody.user.domain.repository

import com.coachmybody.user.domain.UserAuth
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserAuthRepository : JpaRepository<UserAuth, Long> {

}