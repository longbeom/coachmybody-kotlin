package com.coachmybody.routine.interfaces.dto

import com.coachmybody.routine.domain.Routine
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "루틴 정보 응답")
data class RoutineSimpleResponse(

        @ApiModelProperty(value = "루틴 id", required = false)
        val id: Long?,

        @ApiModelProperty(value = "루틴 제목", required = false)
        val title: String,

        @ApiModelProperty(value = "썸네일 이미지", required = false)
        val imageUri: String,

        @ApiModelProperty(value = "운동 수", required = false)
        val exerciseCount: Int

) {
        companion object {
                fun of(routine: Routine): RoutineSimpleResponse {
                        return RoutineSimpleResponse(
                                id = routine.id,
                                title = routine.title,
                                imageUri = "",
                                exerciseCount = 0
                        )
                }
        }
}