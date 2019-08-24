package com.coffee.chooser.coffeeservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class CoffeeController @Autowired constructor(coffeeProperties: List<CoffeeProperties>) {

    private final val coffeeProperties: Map<String, CoffeeProperties> = coffeeProperties.map { it.language to it }.toMap()

    @GetMapping("/coffee")
    fun chooseCoffee(@RequestHeader("content-language") language: String?) : Coffee? {
        return calculateCoffeeOfTheDay(language ?: "english")
    }

    private fun calculateCoffeeOfTheDay(language: String) : Coffee? {
        return coffeeProperties[language]?.coffee?.shuffled()?.get(0)
    }
}
