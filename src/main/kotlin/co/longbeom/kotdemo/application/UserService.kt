package co.longbeom.kotdemo.application

import co.longbeom.kotdemo.user.domain.User
import co.longbeom.kotdemo.user.domain.repository.UserRepository
import co.longbeom.kotdemo.user.interfaces.dto.RegisterRequest
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
}