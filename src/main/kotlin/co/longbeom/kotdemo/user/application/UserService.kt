package co.longbeom.kotdemo.user.application

import co.longbeom.kotdemo.user.domain.User
import co.longbeom.kotdemo.user.domain.repository.UserRepository
import co.longbeom.kotdemo.user.interfaces.dto.RegisterRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    fun register(registerRequest: RegisterRequest): Unit {
        val socialId = registerRequest.socialId

        if (userRepository.findBySocialId(socialId).isPresent) {
            throw IllegalArgumentException()
        }

        val user = User(
                id = UUID.randomUUID().toString(),
                socialId = socialId,
                loginType = registerRequest.loginType,
                nickname = registerRequest.nickname,
                email = registerRequest.email
        )

        userRepository.save(user)
    }
}