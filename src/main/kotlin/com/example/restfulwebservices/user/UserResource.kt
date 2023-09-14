package com.example.restfulwebservices.user

import com.example.restfulwebservices.exception.UserNotFoundException
import jakarta.validation.Valid
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
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
    fun retrieveUserById(@PathVariable id: Int ): EntityModel<User> {
        val user: User = service.find(id) ?: throw UserNotFoundException("id= $id")
        val entityModel = EntityModel.of(user)
        val link: WebMvcLinkBuilder = linkTo(methodOn(this::class.java).retrieveAllUsers())
        entityModel.add(link.withRel("all-users"))
        return entityModel
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