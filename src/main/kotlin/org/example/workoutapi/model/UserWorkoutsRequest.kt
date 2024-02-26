package org.example.workoutapi.model

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class UserWorkoutsRequest(
    val userId: String,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val startDateTime: LocalDateTime,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val endDateTime: LocalDateTime
)