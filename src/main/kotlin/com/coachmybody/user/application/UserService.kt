package com.coachmybody.user.application

import com.coachmybody.user.domain.User
import com.coachmybody.user.domain.UserAuth
import com.coachmybody.user.domain.repository.UserAuthRepository
import com.coachmybody.user.domain.repository.UserRepository
import com.coachmybody.user.interfaces.dto.LoginResponse
import com.coachmybody.user.interfaces.dto.RegisterRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class UserService(
    @Autowired var userRepository: UserRepository,
    @Autowired var userAuthRepository: UserAuthRepository
) {
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

    @Transactional
    fun login(socialId: String): LoginResponse {
        val user = userRepository.findBySocialId(socialId).get() ?: throw IllegalArgumentException("No User")
        val userId = user.id
        val newAuthOptional = userAuthRepository.findByUserId(userId)

        var newAuth = UserAuth.newAuth(userId)
        if (newAuthOptional.isPresent) {
            newAuth = newAuthOptional.get()
        }
        newAuth.refresh()

        userAuthRepository.save(newAuth)

        return LoginResponse.of(newAuth)
    }
}