package co.longbeom.kotdemo.interfaces.dto

data class UserResponse(
        var id: Long? = null,
        var name: String? = "",
        var address: String? = ""
        )