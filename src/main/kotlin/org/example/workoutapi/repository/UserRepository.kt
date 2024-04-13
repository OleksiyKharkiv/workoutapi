package org.example.workoutapi.repository

import org.example.workoutapi.model.User
import org.example.workoutapi.model.UserWorkout
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface UserRepository : MongoRepository<User, String> {
    override fun findAll(pageable: Pageable): Page<User>

    // Найти пользователя по его идентификатору
    fun findByUserId(userId: String): User?

    @Query("{'userId': ?0, 'userWorkouts.startDate': {\$gte: ?1, \$lte: ?2}}")
    fun findUserAndWorkoutsByTimeInterval(
        userId: String,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    ): List<UserWorkout>
}