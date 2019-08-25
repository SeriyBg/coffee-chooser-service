package com.coffee.chooser.coffeeservice

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "en")
class CoffeeConfigProperties : CoffeeProperties {
    override var coffee: List<Coffee>? = null
    override val language: String = "english"
}

@Configuration
@ConfigurationProperties(prefix = "ua")
class CoffeeUkrainianConfigProperties : CoffeeProperties {
    override var coffee: List<Coffee>? = null
    override val language: String = "ukrainian"
}

interface CoffeeProperties {
    var coffee: List<Coffee>?
    val language: String
}

class Coffee {
    var name: String? = null
    var type: String? = null
    var regions: List<String> = mutableListOf()

    override fun toString(): String {
        return "Coffee(name=$name, type=$type, regions=$regions)"
    }
}

