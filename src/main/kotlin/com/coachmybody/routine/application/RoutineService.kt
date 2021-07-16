package com.coachmybody.routine.application

import com.coachmybody.common.exception.NotFoundEntityException
import com.coachmybody.routine.domain.Routine
import com.coachmybody.routine.domain.repository.RoutineRepository
import com.coachmybody.routine.interfaces.dto.RoutineSimpleResponse
import com.coachmybody.user.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

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


    @Transactional(readOnly = true)
    fun getMyRoutines(user: User, hasExercise: Boolean): List<RoutineSimpleResponse> {

        return routineRepository.findAllByUser(user)
                .stream().map { routine -> RoutineSimpleResponse.of(routine) }
                .collect(Collectors.toList())
    }


    @Transactional
    fun updateRoutineTitle(routineId: Long, title: String) {
        var routine = routineRepository.findById(routineId).get() ?: throw NotFoundEntityException()

        routine.title = title

        routineRepository.save(routine)
    }
}