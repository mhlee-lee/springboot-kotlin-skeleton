package org.test.kotlin_base

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinBaseApplication

fun main(args: Array<String>) {
    runApplication<KotlinBaseApplication>(*args)
}
