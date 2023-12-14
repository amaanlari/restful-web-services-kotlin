package com.example.restfulwebservices.versioning

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VersioningPersonController {

    @GetMapping("/v1/person")
    fun getFirstVersionOfPerson(): PersonV1 {
        return PersonV1("Bob Charlie")
    }

    @GetMapping("/v2/person")
    fun getSecondVersionOfPerson(): PersonV2 {
        return PersonV2(
            Name(
                firstName = "Bob",
                lastName = "Charlie"
            )
        )
    }

    @GetMapping(path = ["/person"], params = ["version=1"])
    fun getFirstVersionOfPersonRequestParam(): PersonV1 {
        return PersonV1("Bob Charlie")
    }

    @GetMapping(path = ["/person"], params = ["version=2"])
    fun getSecondVersionOfPersonRequestParam(): PersonV2 {
        return PersonV2(
            Name(
                firstName = "Bob",
                lastName = "Charlie"
            )
        )
    }

    @GetMapping(path = ["/person/header"], headers = ["X-API-VERSION=1"])
    fun getFirstVersionOfPersonRequestHeader(): PersonV1 {
        return PersonV1("Bob Charlie")
    }

    @GetMapping(path = ["/person/header"], headers = ["X-API-VERSION=2"])
    fun getSecondVersionOfPersonRequestHeader(): PersonV2 {
        return PersonV2(
            Name(
                firstName = "Bob",
                lastName = "Charlie"
            )
        )
    }

//    application/vnd.lari.api-v1+json
    @GetMapping(path = ["/person"], produces = ["application/vnd.lari.api-v1+json"])
    fun getFirstVersionOfPersonAcceptHeader(): PersonV1 {
        return PersonV1("Bob Charlie")
    }

    @GetMapping(path = ["/person"], produces = ["application/vnd.lari.api-v2+json"])
    fun getSecondVersionOfPersonAcceptHeader(): PersonV2 {
        return PersonV2(
            Name(
                firstName = "Bob",
                lastName = "Charlie"
            )
        )
    }
}