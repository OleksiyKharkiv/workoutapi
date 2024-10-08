package org.example.workoutapi.controller

import lombok.RequiredArgsConstructor
import org.example.workoutapi.model.User
import org.example.workoutapi.model.UserWorkout
import org.example.workoutapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
// Controller
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/all")
    fun getAllUserWorkout(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "20") size: Int
    ): ResponseEntity<Page<User>> {
        val pageable: Pageable = PageRequest.of(page, size)
        val users = userService.getAllUsers(pageable)
        return ResponseEntity(users, HttpStatus.OK)
    }

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: String): ResponseEntity<User> {
        val user = userService.getUserById(userId)
        return if (user != null) {
            ResponseEntity.ok(user)
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