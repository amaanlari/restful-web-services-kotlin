package com.example.restfulwebservices.user

import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class User(
    val id: Int,

    @get: Size(min = 2, message = "Name should have at least 2 characters")
    var name: String,

    @get: Past(message = "Date of birth must be in past")
    var birthDate: LocalDate
)