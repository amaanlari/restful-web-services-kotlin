package com.example.restfulwebservices.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
class UserResource (
    val service: UserDaoService
){
    @GetMapping(path = ["/users"])
    fun retrieveAllUsers(): List<User> {
        return service.find()
    }

    @GetMapping("/users/{id}")
    fun retrieveUserById(@PathVariable id: Int ): User? {
        val user: User? = service.find(id)

        return user
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: User) : ResponseEntity<User> {
        service.save(user)
        val location: URI = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.id)
            .toUri()
        return ResponseEntity.created(location).build()
    }
}