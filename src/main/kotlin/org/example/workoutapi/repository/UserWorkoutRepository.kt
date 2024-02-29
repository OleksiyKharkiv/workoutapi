package org.example.workoutapi.repository

import org.example.workoutapi.model.UserWorkout
import org.springframework.data.domain.Page
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Pageable
import java.time.LocalDateTime

@Repository
interface UserWorkoutRepository : MongoRepository<UserWorkout, String> {
    override fun findAll(pageable: Pageable): Page<UserWorkout>

    @Query("{ 'userId' : ?0, 'startDate' : { \$gte : ?1, \$lte : ?2 } }")
    fun findUserWorkoutsByTimeInterval(
        userId: String,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    ): List<UserWorkout>

    @Query("{ 'userId' : ?0, 'startDate' : { \$gte : ?1, \$lte : ?2 }, 'activityType' : {\$exists : true }}")
    fun findPlannedUserWorkouts(
        userId: String,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    ): List<UserWorkout>
}