package com.coffee.chooser.coffeeservice

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@Configuration
@PropertySource(value = ["classpath:coffee.yaml"], factory = YamlPropertySourceFactory::class)
@ConfigurationProperties(prefix = "properties")
class CoffeeConfigProperties {

    var coffee: List<Coffee>? = null

    companion object {
        @Bean
        fun propertySourcesPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
            return PropertySourcesPlaceholderConfigurer()
        }
    }
}

class Coffee {
    var name: String? = null
    var type: String? = null
    var regions: List<String> = mutableListOf()

    override fun toString(): String {
        return "Coffee(name=$name, type=$type, regions=$regions)"
    }
}

