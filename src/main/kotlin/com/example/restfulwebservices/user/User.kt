package com.example.restfulwebservices.user

import java.time.LocalDate

data class User(
    private val id: Int,
    private var name: String,
    private var birthDate: LocalDate
) {
    override fun toString(): String {
        return "User(id=$id, name='$name', birthDate=$birthDate)"
    }
}