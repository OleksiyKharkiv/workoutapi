package org.example.workoutapi.controller

import org.example.workoutapi.dto.UserDTO
import org.example.workoutapi.mapper.UserMapper
import org.example.workoutapi.model.User
import org.example.workoutapi.model.UserWorkout
import org.example.workoutapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: String): ResponseEntity<UserDTO> {
        val user = userService.getUserById(userId)
        return if (user != null) {
            ResponseEntity.ok(UserMapper.toDto(user))
        } else {
            ResponseEntity.notFound().build()
        }
    }


    @GetMapping("/{id}/planned-workouts")
    fun getUserPlannedWorkoutsByTimeInterval(
        @PathVariable id: String,
        @RequestParam("startDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) startDateTime: LocalDateTime,
        @RequestParam("endDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) endDateTime: LocalDateTime
    ): Pair<User, List<UserWorkout>>? {
        return userService.getUserAndWorkoutsByTimeInterval(id, startDateTime, endDateTime)
    }
}