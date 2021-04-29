package co.longbeom.kotdemo.user.interfaces

import co.longbeom.kotdemo.application.UserService
import co.longbeom.kotdemo.user.interfaces.dto.RegisterRequest
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Api(tags = ["Auth"])
@RequestMapping("/api/v1/auth")
@RestController
class AuthController {
    @Autowired
    private lateinit var userService: UserService

    @ApiOperation(value = "회원가입")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    fun register(@RequestBody @Valid registerRequest: RegisterRequest) {
        userService.register(registerRequest)
    }
}