package org.example.workoutapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(
    @Id
    val id: String? = null,
    val userId: String,
    val language: String,
    val birthday: String,
    val gender: String,
    val accountType: String,
    val aboType: String,
    val isPremiumPaid: Boolean,
    val connectedCoachUserId: String?,
    val connectedCoachName: String?,
    val dateTimeRegisterComplete: String,
    val workoutActivitiesCount: Int,
    val sportTypes: List<String>
)