package com.coachmybody.routine.domain.repository

import com.coachmybody.routine.domain.Routine
import com.coachmybody.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoutineRepository : JpaRepository<Routine, Long> {

    fun findAllByUser(user: User): List<Routine>

}