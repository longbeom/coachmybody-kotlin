package co.longbeom.kotdemo.application

import co.longbeom.kotdemo.domain.repository.UserRepository
import co.longbeom.kotdemo.interfaces.dto.UserCreateRequest
import co.longbeom.kotdemo.interfaces.dto.UserResponse
import co.longbeom.kotdemo.interfaces.dto.UserUpdateRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun saveUser(userCreateRequest: UserCreateRequest): Boolean {
        userRepository.save(userCreateRequest.toEntity())
        return true
    }

    fun findById(userId: Long): UserResponse {
        val user = userRepository.findById(userId).orElse(null)
        return user.toUserResponse()
    }

    fun updateUser(userId: Long, userUpdateRequest: UserUpdateRequest): UserResponse {
        userRepository.save(userUpdateRequest.toEntity(userId))
        val user = userRepository.findById(userId).orElse(null)
        return user.toUserResponse()
    }

    fun deleteById(userId: Long): Boolean {
        userRepository.deleteById(userId)
        return true
    }
}