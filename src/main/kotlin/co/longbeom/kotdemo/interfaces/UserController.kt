package co.longbeom.kotdemo.interfaces

import co.longbeom.kotdemo.application.UserService
import co.longbeom.kotdemo.user.interfaces.dto.RegisterRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/users")
@RestController
class UserController {
    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun saveUser(@RequestBody registerRequest: RegisterRequest): Any {
        return userService.register(registerRequest)
    }
}