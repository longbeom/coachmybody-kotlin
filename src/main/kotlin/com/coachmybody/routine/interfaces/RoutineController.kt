package com.coachmybody.routine.interfaces

import com.coachmybody.common.dto.HeaderDto
import com.coachmybody.routine.application.RoutineService
import com.coachmybody.routine.interfaces.dto.RoutineSimpleResponse
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
@RequestMapping("/api/v1")
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
    @PostMapping("/routines")
    fun create(@RequestParam(name = "title") title: String,
               @RequestHeader httpHeaders: HttpHeaders) {

        val headerDto = HeaderDto.of(httpHeaders)
        val user = userService.findByToken(headerDto.token)

        routineService.create(title, user)
    }


    @ApiOperation(value = "내 루틴 리스트 조회")
    @ApiResponse(code = 200, message = "내 루틴 리스트 조회 성공")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/routines")
    fun getMyRoutines(@RequestHeader httpHeaders: HttpHeaders,
                      @RequestParam(value = "hasExercise", required = false) hasExercise: Boolean): List<RoutineSimpleResponse> {

        val user = userService.findUserByHeader(httpHeaders)

        return routineService.getMyRoutines(user, hasExercise);
    }


    @ApiOperation(value = "루틴 제목 수정")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "루틴 제목 수정 성공"),
        ApiResponse(code = 404, message = "존재하지 않는 루틴")
    ])
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/routines/{routineId}/title")
    fun updateRoutineTitle(@RequestHeader httpHeaders: HttpHeaders,
                           @PathVariable(value = "routineId") routineId: Long,
                           @RequestParam(value = "title", required = true) title: String) {

        routineService.updateRoutineTitle(routineId, title);
    }


}