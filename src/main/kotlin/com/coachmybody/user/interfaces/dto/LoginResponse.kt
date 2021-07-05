package com.coachmybody.user.interfaces.dto

import com.coachmybody.user.domain.UserAuth
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.Instant

@ApiModel(description = "로그인 응답")
data class LoginResponse(
        @ApiModelProperty(value = "액세스 토큰", required = true)
        val accessToken: String,

        @ApiModelProperty(value = "리프레시 토큰", required = true)
        val refreshToken: String,

        @ApiModelProperty(value = "토큰 만료 날짜", required = true)
        val expiredAt: Instant
) {
    companion object {
        fun of(userAuth: UserAuth): LoginResponse {
            return LoginResponse(
                    accessToken = userAuth.accessToken,
                    refreshToken = userAuth.refreshToken,
                    expiredAt = userAuth.expiredAt
            )
        }
    }
}