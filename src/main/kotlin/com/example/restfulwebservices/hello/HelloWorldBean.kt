package com.example.restfulwebservices.hello

data class HelloWorldBean(
    val message: String = "Hello world - Bean"
) {
    override fun toString(): String {
        return "HellowWorldBean [message= ${message}]"
    }
}
