package co.longbeom.kotdemo.interfaces.dto

import co.longbeom.kotdemo.domain.model.User

data class UserUpdateRequest(val name: String, val address: String) {
    fun toEntity(userId: Long): User {
        return User(id = userId, name, address)
    }
}