package co.longbeom.kotdemo.interfaces

import co.longbeom.kotdemo.application.UserService
import co.longbeom.kotdemo.interfaces.dto.UserCreateRequest
import co.longbeom.kotdemo.interfaces.dto.UserUpdateRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/users")
@RestController
class UserController {
    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun saveUser(@RequestBody userCreateRequest: UserCreateRequest): ResponseEntity<Any> {
        return ResponseEntity
                .ok()
                .body(userService.saveUser(userCreateRequest))
    }

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: Long): ResponseEntity<Any> {
        return ResponseEntity
                .ok()
                .body(userService.findById(userId))
    }

    @PatchMapping("/{userId}")
    fun updateUserById(@PathVariable userId: Long, @RequestBody userUpdateRequest: UserUpdateRequest): ResponseEntity<Any> {
        return ResponseEntity
                .ok()
                .body(userService.updateUser(userId, userUpdateRequest))
    }

    @DeleteMapping("/{userId}")
    fun deleteUserById(@PathVariable userId: Long): ResponseEntity<Any> {
        return ResponseEntity
                .ok()
                .body(userService.deleteById(userId))
    }
}