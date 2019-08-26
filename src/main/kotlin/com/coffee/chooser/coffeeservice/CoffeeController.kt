package com.coffee.chooser.coffeeservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CoffeeController(val coffeeConfigProperties: CoffeeConfigProperties) {

    @GetMapping("/coffee")
    fun chooseCoffee() : Coffee? {
        Thread.sleep(3_000)
        return coffeeConfigProperties.coffee?.shuffled()?.get(0)
    }
}
