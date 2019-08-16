package com.coffee.chooser.coffeeservice

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.core.env.PropertiesPropertySource
import org.springframework.core.env.PropertySource
import org.springframework.core.io.Resource
import org.springframework.core.io.support.EncodedResource
import org.springframework.core.io.support.PropertySourceFactory
import java.util.*

@SpringBootApplication
@EnableConfigurationProperties(value = [CoffeeConfigProperties::class])
class CoffeeServiceApplication

fun main(args: Array<String>) {
	runApplication<CoffeeServiceApplication>(*args)
}


class YamlPropertySourceFactory : PropertySourceFactory {
	override fun createPropertySource(name: String?, resource: EncodedResource): PropertySource<*> {
		val properties = loadYamlIntoProperties(resource.resource)
		return PropertiesPropertySource(if (name?.isBlank() != false) resource.resource.filename!! else name, properties)
	}

	private fun loadYamlIntoProperties(resources: Resource) : Properties {
		val factory = YamlPropertiesFactoryBean()
		factory.setResources(resources)
		factory.afterPropertiesSet()
		return factory.`object`!!
	}
}