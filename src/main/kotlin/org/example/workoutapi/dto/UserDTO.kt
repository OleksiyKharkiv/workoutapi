package org.example.workoutapi.dto

import java.time.LocalDateTime

data class UserDTO(
    val id: String?,
    val userId: String,
    val language: String,
    val birthday: String,
    val gender: String,
    val accountType: String,
    val aboType: String,
    val isPremiumPaid: Boolean,
    val connectedCoachUserId: String?,
    val connectedCoachName: String?,
    val dateTimeRegisterComplete: LocalDateTime,
    val workoutActivitiesCount: Int,
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
    val premiumPaid: String,
    val premiumTrial: String,
    val pushMessagesON: String,
    val shopLastAbo: String,
    val usageOfDiagnosticFree: Int,
    val usageOfDiagnosticPaid: Int,
)