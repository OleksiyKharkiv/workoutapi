package org.example.workoutapi.service

import org.example.workoutapi.model.UserWorkout
import org.example.workoutapi.repository.UserWorkoutRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable
import java.time.LocalDateTime

@Service
class UserWorkoutService {

    @Autowired
    lateinit var userWorkoutRepository: UserWorkoutRepository
    fun getAllUserWorkout(pageable: Pageable): Page<UserWorkout> {
        return userWorkoutRepository.findAll(pageable)
    }

    fun getUserWorkoutById(id: String): UserWorkout {
        return userWorkoutRepository.findById(id)
            .orElseThrow { NoSuchElementException("User workout with id $id not found") }
    }

    fun getUserWorkoutsByTimeInterval(
        userId: String,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    ): List<UserWorkout> {
        return userWorkoutRepository.findUserWorkoutsByTimeInterval(userId, startDateTime, endDateTime)
    }

    fun createUserWorkout(userWorkout: UserWorkout): UserWorkout {
        return userWorkoutRepository.save(userWorkout)
    }

    fun updateUserWorkout(id: String, userWorkout: UserWorkout): UserWorkout {
        val existingUserWorkout = userWorkoutRepository.findById(id)
            .orElseThrow { NoSuchElementException("User workout with id $id not found") }
        // Update fields of existingUserWorkout with data from userWorkout
        // For example:
        existingUserWorkout.workoutType = userWorkout.workoutType
        existingUserWorkout.hashtags = userWorkout.hashtags
        // Update other fields similarly

        return userWorkoutRepository.save(existingUserWorkout)
    }

    fun deleteUserWorkout(id: String) {
        val existingUserWorkout = userWorkoutRepository.findById(id)
            .orElseThrow { NoSuchElementException("User workout with id $id not found") }
        userWorkoutRepository.delete(existingUserWorkout)
    }

    fun getPlannedUserWorkouts(
        userId: String,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    ): List<UserWorkout> {
        return userWorkoutRepository.findPlannedUserWorkouts(userId, startDateTime, endDateTime)
    }
}