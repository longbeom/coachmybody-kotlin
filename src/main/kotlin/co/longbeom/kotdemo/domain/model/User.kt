package co.longbeom.kotdemo.domain.model

import co.longbeom.kotdemo.interfaces.dto.UserCreateRequest
import co.longbeom.kotdemo.interfaces.dto.UserResponse
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    var address: String
) {
    fun toUserResponse(): UserResponse {
        return UserResponse(
                id = id,
                name = name,
                address = address
        )
    }

    fun toUserRequest(): UserCreateRequest {
        return UserCreateRequest(
                name = name,
                address = address
        )
    }
}