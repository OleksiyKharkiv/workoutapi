package org.example.workoutapi.dto

import java.time.LocalDateTime

data class UserWorkoutDTO(
    val id: String? = null,
    val userId: String,
    val workoutType: String,
    val startDate: LocalDateTime,
    val duration: Long,
    val metricValue: String,
    val hashtags: List<String>,
    val createdBy: String,
    val created: Any,
    val segments: List<Any>,
    val _class: String
)