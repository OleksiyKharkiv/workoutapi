package org.example.workoutapi.service

import org.example.workoutapi.model.User
import org.example.workoutapi.model.UserWorkout
import org.example.workoutapi.repository.UserRepository
import org.example.workoutapi.repository.UserWorkoutRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var userWorkoutRepository: UserWorkoutRepository

    fun getUserById(id: String): User? {
        return userRepository.findByUserId(id)
    }

    fun getUserAndWorkoutsByTimeInterval(
        userId: String,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    ): Pair<User, List<UserWorkout>>? {
        val user = userRepository.findById(userId).orElse(null)
        val workouts = userWorkoutRepository.findUserWorkoutsByTimeInterval(userId, startDateTime, endDateTime)
        return if (user != null) Pair(user, workouts) else null
    }
}