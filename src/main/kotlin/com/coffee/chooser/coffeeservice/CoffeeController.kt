package com.coffee.chooser.coffeeservice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CoffeeController(val coffeeConfigProperties: CoffeeConfigProperties) {

    @GetMapping("/coffee")
    fun chooseCoffee() : Coffee? {
        throw ServiceUnavailable()
        return coffeeConfigProperties.coffee?.shuffled()?.get(0)
    }

    @GetMapping("/health")
    fun health() = "Ok"
}

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
class ServiceUnavailable : RuntimeException()
