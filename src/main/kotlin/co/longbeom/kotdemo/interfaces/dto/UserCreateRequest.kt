package co.longbeom.kotdemo.interfaces.dto

import co.longbeom.kotdemo.domain.model.User

data class UserCreateRequest(
        val name: String,
        val address: String
) {
        fun toEntity(): User {
            return User(
                    name = name,
                    address = address
            )
        }
}