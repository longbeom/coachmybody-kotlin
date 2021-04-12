package co.longbeom.kotdemo.user.interfaces.dto

import co.longbeom.kotdemo.user.type.LoginType
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@ApiModel
data class RegisterRequest(
        @ApiModelProperty(value = "소셜 아이디", required = true)
        @field:NotNull(message = "The socialId must not be Null")
        val socialId: String,

        @ApiModelProperty(value = "로그인 타입", required = true)
        @field:NotNull(message = "The loginType must not be Null")
        val loginType: LoginType,

        @ApiModelProperty(value = "닉네임", required = true)
        @field:NotNull(message = "The nickname must not be Null")
        val nickname: String,

        @ApiModelProperty(value = "이메일", required = true)
        @field:Email
        val email: String
)