package com.example.restfulwebservices.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class UserResource (
    val service: UserDaoService
){
    @GetMapping(path = ["/users"])
    fun retrieveAllUsers(): List<User> {
        return service.find()
    }

    @GetMapping("/users/{id}")
    fun retrieveUserById(@PathVariable id: Int ) = service.find(id = id)
}