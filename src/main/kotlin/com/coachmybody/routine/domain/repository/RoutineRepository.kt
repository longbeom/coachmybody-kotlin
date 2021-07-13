package com.coachmybody.routine.domain.repository

import com.coachmybody.routine.domain.Routine
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoutineRepository : JpaRepository<Routine, Long> {
}