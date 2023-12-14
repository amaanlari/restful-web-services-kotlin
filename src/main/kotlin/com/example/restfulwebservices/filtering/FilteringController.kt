package com.example.restfulwebservices.filtering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FilteringController {

    @GetMapping("/filtering")
    fun filtering(): SomeBean {
        return SomeBean("value 1", "value 2", "value 3")
    }

    @GetMapping ("/filtering-list")
    fun filteringList(): List<SomeBean> {
        return listOf(
            SomeBean("a1", "a2", "a3"),
            SomeBean("b1", "b2", "b3")
        )
    }
}