package com.example.restfulwebservices.filtering

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("field1", "field2")
data class SomeBean (
    val field1: String,
    val field2: String,
    val field3: String
)
