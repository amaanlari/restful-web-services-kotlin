package com.example.restfulwebservices.versioning

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VersioningPersonController {

    @GetMapping("/v1/person")
    fun gerFirstVersionOfPerson(): PersonV1 {
        return PersonV1("Bob Charlie")
    }

    @GetMapping("/v2/person")
    fun gerSecondVersionOfPerson(): PersonV2 {
        return PersonV2(
            Name(
                firstName = "Bob",
                lastName = "Charlie"
            )
        )
    }

    @GetMapping(path = ["/person"], params = ["version=1"])
    fun gerFirstVersionOfPersonRequestParam(): PersonV1 {
        return PersonV1("Bob Charlie")
    }

    @GetMapping(path = ["/person"], params = ["version=2"])
    fun gerSecondVersionOfPersonRequestParam(): PersonV2 {
        return PersonV2(
            Name(
                firstName = "Bob",
                lastName = "Charlie"
            )
        )
    }
}