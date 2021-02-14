package co.longbeom.kotdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotDemoApplication

fun main(args: Array<String>) {
	runApplication<KotDemoApplication>(*args)
}
