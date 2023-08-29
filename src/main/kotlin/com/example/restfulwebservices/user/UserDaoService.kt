package com.example.restfulwebservices.user

import com.example.restfulwebservices.exception.UserNotFoundException
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.function.Predicate

@Component
class UserDaoService {

    private lateinit var users: MutableList<User>
    init {
        mutableListOf(
            User(1, "Shreyashi", LocalDate.of(2002, 1, 3)),
            User(2, "Amisha", LocalDate.of(2001, 4, 14)),
            User(3, "Zehra", LocalDate.of(2003, 6, 30))
        ).also { users = it }
    }

    fun find(): List<User> {
        return users
    }

    fun find(id: Int): User? {
        return users.find{it.id == id}
    }

    fun save(user: User){
        users.add(user)
    }

    fun deleteById(id: Int){
        users.removeIf{it.id == id}
    }
}