package org.example.workoutapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "userWorkout")
@CompoundIndex(name = "userId_startDate_idx", def = "{'userId': 1, 'startDate': -1}")
data class UserWorkout(
    @Id
    val id: String? = null,
    @Indexed
    val activityType: String,
    val hashtags: List<String>,
    @Indexed
    val metricTypeId: String,
    @Indexed
    val metricValue: String,
    @Indexed
    val startDate: Long,
    @Indexed
    val userId: String,
    @Indexed
    val userWorkoutLibraryId: String,
    @Indexed
    val workoutType: String
)