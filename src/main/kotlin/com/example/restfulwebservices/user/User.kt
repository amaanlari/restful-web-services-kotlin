package com.example.restfulwebservices.user

import java.time.LocalDate

data class User(
    val id: Int,
    var name: String,
    var birthDate: LocalDate
)