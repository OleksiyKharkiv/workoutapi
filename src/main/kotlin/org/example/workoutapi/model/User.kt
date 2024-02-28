package org.example.workoutapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "users")
data class User(
    @Id
    val id: String? = null,
    @Indexed(unique = true)
    val userId: String,
    @Indexed
    val language: String,
    @Indexed
    val birthday: String,
    @Indexed
    val gender: String,
    @Indexed
    val accountType: String,
    @Indexed
    val aboType: String,
    @Indexed
    val isPremiumPaid: Boolean,
    val connectedCoachUserId: String?,
    val connectedCoachName: String?,
    @Indexed
    val dateTimeRegisterComplete: LocalDateTime,
    @Indexed
    val workoutActivitiesCount: Int,
    @Indexed
    val sportTypes: List<String>,
    val dateTimeRegisterStart: LocalDateTime,
    val dateFirstAboStart: LocalDateTime,
    val dateLastAboStart: LocalDateTime,
    val endOfFreeTrialPeriod: LocalDateTime,
    val firstAboSubscriptionPlan: String,
    val firstAboVendor: String,
    val lastAboSubscriptionPlan: String,
    val lastAboVendor: String,
    val newsletterOptInStatus: String,
    @Indexed
    val premiumPaid: String,
    @Indexed
    val premiumTrial: String,
    val pushMessagesON: String,
    val shopLastAbo: String,
    val usageOfDiagnosticFree: Int,
    val usageOfDiagnosticPaid: Int,
)