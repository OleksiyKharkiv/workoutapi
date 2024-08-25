package org.example.workoutapi.model

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    val duration: Duration?,
    val metricValue: String?,
    val nutrition: Nutrition?,
    val nutritionUnits: NutritionUnits?,
    var hashtags: List<String>,
    val createdBy: String,
    val created: CreatedInfo,
    val segments: List<Any>,
    val _class: String
)

data class Duration(
    val time: Long = 0,
    val distance: Double?,
    val distanceType: String?
)

data class Nutrition(
    val PRE: NutritionInfo?,
    val WORKOUT: NutritionInfo?,
    val POST: NutritionInfo?
)

data class NutritionInfo(
    val FLUID: Int?,
    val CARB: Int?,
    val PROTEIN: Int?
)

data class NutritionUnits(
    val PRE: UnitsInfo?,
    val WORKOUT: UnitsInfo?,
    val POST: UnitsInfo?
)

data class UnitsInfo(
    val FLUID_UNIT: String,
    val CARB_UNIT: String,
    val PROTEIN_UNIT: String
)

data class CreatedInfo(
    val userId: String,
    val timestamp: LocalDateTime
)