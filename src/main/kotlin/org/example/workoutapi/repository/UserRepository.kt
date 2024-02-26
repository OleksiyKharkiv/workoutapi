package org.example.workoutapi.repository

import org.example.workoutapi.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface UserRepository : MongoRepository<User, String> {
    // Найти пользователя по его идентификатору
    fun findByUserId(userId: String): User?

    @Query("{'_id': ?0, 'userWorkouts.startDate': {\$gte: ?1, \$lte: ?2}}")
    fun findUserAndWorkoutsByTimeInterval(id: String, startDateTime: LocalDateTime, endDateTime: LocalDateTime): User?
}