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
    val userId: String,
    @Indexed
    var workoutType: String,
    @Indexed
    val startDate: Long,
    val duration: Long, // Предполагается, что это длительность тренировки в миллисекундах
    val metricValue: String,
    var hashtags: List<String>,
    val createdBy: String,
    val created: Any, // Предполагается, что это объект, содержащий информацию о создании
    val segments: List<Any>, // Предполагается, что это список сегментов тренировки
    val _class: String // Предполагается, что это поле для класса
)