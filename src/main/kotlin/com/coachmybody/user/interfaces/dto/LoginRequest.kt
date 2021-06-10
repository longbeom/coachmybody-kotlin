package com.coachmybody.user.interfaces.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotNull

@ApiModel(description = "로그인 요청")
data class LoginRequest(
        @ApiModelProperty(value = "소셜 아이디", required = true)
        @field:NotNull(message = "The socialId must not be Null")
        val socialId: String
)