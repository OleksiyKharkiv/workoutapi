package org.example.workoutapi.service

import org.example.workoutapi.model.User
import org.example.workoutapi.model.UserWorkout
import org.example.workoutapi.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService {
    val logger: org.slf4j.Logger? = LoggerFactory.getLogger(UserService::class.java)

    @Autowired
    lateinit var userRepository: UserRepository

    fun getUserById(id: String): User? {
        logger?.info("Fetching user by id: {}", id)
        val user = userRepository.findByUserId(id)
        if (user == null) {
            logger?.warn("User not found for id: {}", id)
        } else {
            logger?.info("User found: {}", user)
        }
        return user
    }

    fun getUserAndWorkoutsByTimeInterval(
        userId: String,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    ): Pair<User, List<UserWorkout>>? {
        val user = userRepository.findById(userId).orElse(null)
        val workouts = userRepository.findUserAndWorkoutsByTimeInterval(userId, startDateTime, endDateTime)
        return if (user != null) Pair(user, workouts) else null
    }
}