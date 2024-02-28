package org.example.workoutapi.mapper

import org.example.workoutapi.dto.UserDTO
import org.example.workoutapi.model.User

object UserMapper {
    fun toDto(user: User): UserDTO {
        return UserDTO(
            id = user.id,
            userId = user.userId,
            language = user.language,
            birthday = user.birthday,
            gender = user.gender,
            accountType = user.accountType,
            aboType = user.aboType,
            isPremiumPaid = user.isPremiumPaid,
            connectedCoachUserId = user.connectedCoachUserId,
            connectedCoachName = user.connectedCoachName,
            dateTimeRegisterComplete = user.dateTimeRegisterComplete,
            workoutActivitiesCount = user.workoutActivitiesCount,
            sportTypes = user.sportTypes,
            dateTimeRegisterStart = user.dateTimeRegisterStart,
            dateFirstAboStart = user.dateFirstAboStart,
            dateLastAboStart = user.dateLastAboStart,
            endOfFreeTrialPeriod = user.endOfFreeTrialPeriod,
            firstAboSubscriptionPlan = user.firstAboSubscriptionPlan,
            firstAboVendor = user.firstAboVendor,
            lastAboSubscriptionPlan = user.lastAboSubscriptionPlan,
            lastAboVendor = user.lastAboVendor,
            newsletterOptInStatus = user.newsletterOptInStatus,
            premiumPaid = user.premiumPaid,
            premiumTrial = user.premiumTrial,
            pushMessagesON = user.pushMessagesON,
            shopLastAbo = user.shopLastAbo,
            usageOfDiagnosticFree = user.usageOfDiagnosticFree,
            usageOfDiagnosticPaid = user.usageOfDiagnosticPaid
        )
    }
}