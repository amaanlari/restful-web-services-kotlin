package com.example.restfulwebservices.user

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(
    value = HttpStatus.NOT_FOUND,
    code = HttpStatus.NOT_FOUND,
    reason = "No user found which matches the provided id"
)
class UserNotFoundException(override val message: String?) : RuntimeException()
