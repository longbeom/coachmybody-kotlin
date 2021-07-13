package com.coachmybody.routine.interfaces

import com.coachmybody.common.dto.HeaderDto
import com.coachmybody.routine.application.RoutineService
import com.coachmybody.user.application.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Api(tags = ["Routine"])
@RequestMapping("/api/v1/routine")
@RestController
class RoutineController(
        @Autowired val routineService: RoutineService,
        @Autowired val userService: UserService
) {
    @ApiOperation(value = "루틴 생성")
    @ApiResponses(
            value = [
                ApiResponse(code = 201, message = "루틴 생성 성공"),
                ApiResponse(code = 400, message = "파라미터 오류")
            ]
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@RequestParam(name = "title") title: String,
    @RequestHeader httpHeaders: HttpHeaders) {
        val headerDto = HeaderDto.of(httpHeaders)
        val user = userService.findByToken(headerDto.token)

        routineService.create(title, user)
    }
}