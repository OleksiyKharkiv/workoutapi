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

    fun getUserById(id: String): User {
        return userRepository.findById(id).orElseThrow { NoSuchElementException("User with id $id not found") }
    }

    fun getUserPlannedWorkoutsByTimeInterval(userId: String, startDateTime: LocalDateTime, endDateTime: LocalDateTime): List<UserWorkout> {
        val userWorkouts = userWorkoutRepository.findPlannedUserWorkouts(userId, startDateTime, endDateTime)
        return userWorkouts.sortedBy { it.startDate }
    }
}