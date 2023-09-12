package com.example.restfulwebservices.hello

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(private val messageSource: MessageSource) {

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

    @GetMapping(path = ["/hello-world-internationalized"])
    fun helloWorldInternationalized() : String?{
        val locale = LocaleContextHolder.getLocale()
        return messageSource.getMessage(
            "good.morning.message",
            null,
            "Uh Oh! Didn't work again",
            locale
        )
    }
}