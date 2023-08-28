package com.example.restfulwebservices.hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping(path = ["/hello-world"])
    fun helloWorld(): String {
        return "Hello-World"
    }

    @GetMapping(path = ["/hello-world-bean"])
    fun helloWorldBean(): HelloWorldBean {
        return HelloWorldBean("Hi")
    }

    @GetMapping(path = ["/hello-world/path-var/{name}"])
    fun helloWorldBeanPathVar(@PathVariable name: String): HelloWorldBean {
        return HelloWorldBean("Hello World, $name")
    }
}