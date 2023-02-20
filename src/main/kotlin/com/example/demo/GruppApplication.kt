package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@SpringBootApplication
class SpringBootDockerApplication {
	@RequestMapping("/users")
	fun home(): String {
		return "Hello World!"
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(SpringBootDockerApplication::class.java, *args)
		}
	}
}