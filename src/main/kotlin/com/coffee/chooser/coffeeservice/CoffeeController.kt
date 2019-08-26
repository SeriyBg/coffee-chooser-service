package com.coffee.chooser.coffeeservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CoffeeController(val coffeeConfigProperties: CoffeeConfigProperties) {

    @GetMapping("/coffee")
    fun chooseCoffee() : Coffee? {
        throw IllegalArgumentException("Unexpected bug occurred!")
        return coffeeConfigProperties.coffee?.shuffled()?.get(0)
    }
}
