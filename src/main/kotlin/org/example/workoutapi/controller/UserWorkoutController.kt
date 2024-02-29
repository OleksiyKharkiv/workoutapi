package org.example.workoutapi.controller

import org.example.workoutapi.model.UserWorkout
import org.example.workoutapi.service.UserWorkoutService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Pageable
import java.time.LocalDateTime

@RestController
@RequestMapping("/user-workout")
class UserWorkoutController {

    @Autowired
    lateinit var userWorkoutService: UserWorkoutService
    @GetMapping("/all")
    fun getAllUserWorkout(@RequestParam(defaultValue = "0") page: Int,
                          @RequestParam(defaultValue = "20") size: Int): ResponseEntity<Page<UserWorkout>> {
        val pageable: Pageable = PageRequest.of(page, size)
        val users = userWorkoutService.getAllUserWorkout(pageable)
        return ResponseEntity(users, HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun getUserWorkoutById(@PathVariable id: String): UserWorkout {
        return userWorkoutService.getUserWorkoutById(id)
    }

    @GetMapping
    fun getUserWorkouts(
        @RequestParam userId: String,
        @RequestParam("startDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) startDateTime: LocalDateTime,
        @RequestParam("endDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) endDateTime: LocalDateTime
    ): List<UserWorkout> {
        return userWorkoutService.getUserWorkoutsByTimeInterval(userId, startDateTime, endDateTime)
    }

    @PostMapping
    fun createUserWorkout(@RequestBody userWorkout: UserWorkout): UserWorkout {
        return userWorkoutService.createUserWorkout(userWorkout)
    }

    @PutMapping("/{id}")
    fun updateUserWorkout(@PathVariable id: String, @RequestBody userWorkout: UserWorkout): UserWorkout {
        return userWorkoutService.updateUserWorkout(id, userWorkout)
    }

    @DeleteMapping("/{id}")
    fun deleteUserWorkout(@PathVariable id: String) {
        userWorkoutService.deleteUserWorkout(id)
    }

    @GetMapping("/planned")
    fun getPlannedUserWorkouts(
        @RequestParam userId: String,
        @RequestParam("startDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) startDateTime: LocalDateTime,
        @RequestParam("endDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) endDateTime: LocalDateTime
    ): List<UserWorkout> {
        return userWorkoutService.getPlannedUserWorkouts(userId, startDateTime, endDateTime)
    }
}