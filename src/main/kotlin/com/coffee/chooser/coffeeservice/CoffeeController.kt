package com.coffee.chooser.coffeeservice

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class CoffeeController @Autowired constructor(coffeeProperties: List<CoffeeProperties>) {

    private final val coffeeProperties: Map<String, CoffeeProperties> = coffeeProperties.map { it.language to it }.toMap()

    @GetMapping("/coffee")
    fun chooseCoffee(@RequestHeader("content-language") language: String?) : Coffee? {
        logger.info("Received request for coffee in language: $language")
        return calculateCoffeeOfTheDay(language ?: "en")
    }

    private fun calculateCoffeeOfTheDay(language: String) : Coffee? {
        logger.info("Calculating the coffee of the day...")
        return coffeeProperties[language]?.coffee?.shuffled()?.get(0)
    }

    companion object {
        val logger = LoggerFactory.getLogger(CoffeeController::class.java)!!
    }
}
