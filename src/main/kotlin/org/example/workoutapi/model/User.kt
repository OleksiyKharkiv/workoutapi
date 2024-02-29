package org.example.workoutapi.model

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
data class User(
    @Id
    val id: String? = null,

    @Field("userId")
    @Indexed(unique = true)
    val userId: String,

    @Field("language")
    @Indexed
    val language: String,

    @Field("birthday")
    @Indexed
    val birthday: String,

    @Field("gender")
    @Indexed
    val gender: String,

    @Field("accountType")
    @Indexed
    val accountType: String,

    @Field("aboType")
    @Indexed
    val aboType: String,

    @Builder.Default
    @Field("isPremiumPaid")
    @Indexed
    val isPremiumPaid: Boolean = false,

    @Field("connectedCoachUserId")
    val connectedCoachUserId: String?,

    @Field("connectedCoachName")
    val connectedCoachName: String?,

    @Field("dateTimeRegisterComplete")
    @Indexed
    val dateTimeRegisterComplete: LocalDateTime,

    @Field("workoutActivitiesCount")
    @Indexed
    val workoutActivitiesCount: Int=0,

    @Field("sportTypes")
    @Indexed
    val sportTypes: List<String>,

    @Field("dateTimeRegisterStart")
    val dateTimeRegisterStart: LocalDateTime,

    @Field("dateFirstAboStart")
    val dateFirstAboStart: LocalDateTime,

    @Field("dateLastAboStart")
    val dateLastAboStart: LocalDateTime,

    @Field("endOfFreeTrialPeriod")
    val endOfFreeTrialPeriod: LocalDateTime,

    @Field("firstAboSubscriptionPlan")
    val firstAboSubscriptionPlan: String,

    @Field("firstAboVendor")
    val firstAboVendor: String,

    @Field("lastAboSubscriptionPlan")
    val lastAboSubscriptionPlan: String,

    @Field("lastAboVendor")
    val lastAboVendor: String,

    @Field("newsletterOptInStatus")
    val newsletterOptInStatus: String,

    @Field("premiumPaid")
    @Indexed
    val premiumPaid: String,

    @Field("premiumTrial")
    @Indexed
    val premiumTrial: String,

    @Field("pushMessagesON")
    val pushMessagesON: String,

    @Field("shopLastAbo")
    val shopLastAbo: String,

    @Field("usageOfDiagnosticFree")
    val usageOfDiagnosticFree: Int = 0,

    @Field("usageOfDiagnosticPaid")
    val usageOfDiagnosticPaid: Int = 0,
)