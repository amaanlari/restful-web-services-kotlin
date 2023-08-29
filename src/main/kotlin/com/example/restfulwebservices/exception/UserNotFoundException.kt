package com.example.restfulwebservices.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(
    code = HttpStatus.NOT_FOUND
)
class UserNotFoundException(override val message: String?) : RuntimeException()
