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
    val language: String?,

    @Field("birthday")
    @Indexed
    val birthday: LocalDateTime?,

    @Field("gender")
    @Indexed
    val gender: String?,

    @Field("accountType")
    @Indexed
    val accountType: String?,

    @Field("aboType")
    @Indexed
    val aboType: String,

    @Field("isPremiumPaid")
    @Indexed
    val isPremiumPaid: Boolean,

    @Field("connectedCoachUserId")
    val connectedCoachUserId: String? = null,

    @Field("connectedCoachName")
    val connectedCoachName: String? = null,

    @Field("dateTimeRegisterComplete")
    val dateTimeRegisterComplete: LocalDateTime? = null,

    @Field("workoutActivitiesCount")
    @Indexed
    val workoutActivitiesCount: Int = 0,

    @Field("dateTimeRegisterStart")
    val dateTimeRegisterStart: LocalDateTime,

    @Field("dateFirstAboStart")
    val dateFirstAboStart: LocalDateTime? = null,

    @Field("dateLastAboStart")
    val dateLastAboStart: LocalDateTime? = null,

    @Field("endOfFreeTrialPeriod")
    val endOfFreeTrialPeriod: LocalDateTime? = null,

    @Field("firstAboSubscriptionPlan")
    val firstAboSubscriptionPlan: String? = null,

    @Field("firstAboVendor")
    val firstAboVendor: String? = null,

    @Field("lastAboSubscriptionPlan")
    val lastAboSubscriptionPlan: String? = null,

    @Field("lastAboVendor")
    val lastAboVendor: String? = null,

    @Field("newsletterOptInStatus")
    val newsletterOptInStatus: String? = null,

    @Field("premiumPaid")
    val premiumPaid: String? = null,

    @Field("premiumTrial")
    val premiumTrial: String? = null,

    @Field("pushMessagesON")
    val pushMessagesON: String? = null,

    @Field("shopLastAbo")
    val shopLastAbo: String? = null
)