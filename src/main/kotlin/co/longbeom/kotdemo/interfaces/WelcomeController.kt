package co.longbeom.kotdemo.interfaces

import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["Welcome API"])
@RestController
class WelcomeController {

    @GetMapping(path = ["/"])
    fun welcome() = "Hello Kotlin!"
}