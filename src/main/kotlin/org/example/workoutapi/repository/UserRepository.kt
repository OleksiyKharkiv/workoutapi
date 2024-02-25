package org.example.workoutapi.repository

import org.example.workoutapi.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface UserRepository : MongoRepository<User, String> {
    // Найти пользователя по его идентификатору
    fun findByUserId(userId: String): User?

    // Найти пользователей по интервалу времени регистрации
    fun findByDateTimeRegisterBetween(startDateTime: LocalDateTime, endDateTime: LocalDateTime): List<User>
}