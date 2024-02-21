package workoutapi.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import org.example.workoutapi.model.UserWorkout
import org.example.workoutapi.service.UserWorkoutService
import java.time.LocalDateTime

@RestController
@RequestMapping("/user-workout")
class UserWorkoutController {

    @Autowired
    lateinit var userWorkoutService: UserWorkoutService

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