package co.longbeom.kotdemo.user.interfaces.dto

import co.longbeom.kotdemo.user.domain.User

data class UserUpdateRequest(val name: String, val address: String) {
    fun toEntity(userId: Long): User {
        return User(id = userId, name, address)
    }
}