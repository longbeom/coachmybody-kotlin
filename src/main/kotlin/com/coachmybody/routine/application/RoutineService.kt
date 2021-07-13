package com.coachmybody.routine.application

import com.coachmybody.routine.domain.Routine
import com.coachmybody.routine.domain.repository.RoutineRepository
import com.coachmybody.user.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RoutineService(
        @Autowired var routineRepository: RoutineRepository
) {
    @Transactional
    fun create(title: String, user: User) {

        val routine = Routine(
                title = title,
                user = user
        )

        routineRepository.save(routine)
    }
}