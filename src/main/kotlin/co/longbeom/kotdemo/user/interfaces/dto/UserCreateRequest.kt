package co.longbeom.kotdemo.user.interfaces.dto

import co.longbeom.kotdemo.user.domain.User

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