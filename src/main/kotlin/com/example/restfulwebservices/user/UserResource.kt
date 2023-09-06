package com.example.restfulwebservices.user

import com.example.restfulwebservices.exception.UserNotFoundException
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api/v1")
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

        return user ?: throw UserNotFoundException("id= $id")
    }

    @PostMapping("/users")
    fun createUser(@Valid @RequestBody user: User) : ResponseEntity<User> {
        service.save(user)
        val location: URI = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.id)
            .toUri()
        return ResponseEntity.created(location).build()
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Int) {
        service.deleteById(id)
    }
}