package com.coachmybody.user.application

import com.coachmybody.user.domain.User
import com.coachmybody.user.domain.repository.UserRepository
import com.coachmybody.user.interfaces.dto.RegisterRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    @Transactional
    fun register(registerRequest: RegisterRequest) {
        val socialId = registerRequest.socialId

        if (userRepository.findBySocialId(socialId).isPresent) {
            throw IllegalArgumentException()
        }

        val user = User(
                id = UUID.randomUUID(),
                socialId = socialId,
                loginType = registerRequest.loginType,
                nickname = registerRequest.nickname,
                email = registerRequest.email
        )

        userRepository.save(user)
    }

    fun login(socialId: String) {
        val user = userRepository.findBySocialId(socialId).get() ?: throw IllegalArgumentException("No User")

    }
}