package com.coachmybody.user.interfaces

import com.coachmybody.user.application.UserService
import com.coachmybody.user.interfaces.dto.LoginRequest
import com.coachmybody.user.interfaces.dto.RegisterRequest
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Api(tags = ["Auth"])
@RequestMapping("/api/v1/auth")
@RestController
class AuthController(
        @Autowired val userService: UserService
) {
    @ApiOperation(value = "회원가입")
    @ApiResponses(
            value = [
                ApiResponse(code = 201, message = "회원가입 성공"),
                ApiResponse(code = 400, message = "요청 파라미터 오류"),
                ApiResponse(code = 409, message = "이미 존재하는 회원")
            ]
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    fun register(@RequestBody registerRequest: @Valid RegisterRequest) {
        userService.register(registerRequest)
    }

    @ApiOperation(value = "로그인")
    @ApiResponses(
            value = [
                ApiResponse(code = 200, message = "로그인 성공"),
                ApiResponse(code = 404, message = "존재하지 않는 회원")
            ]
    )
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: @Valid LoginRequest) {
        userService.login(loginRequest.socialId)
    }
}