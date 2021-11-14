package ru.sber.jpa

import Auto
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.sber.jpa.entity.Person
import ru.sber.jpa.repository.PersonRepository


@SpringBootApplication
class Main(private val personRepository: PersonRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {

        val person1 = Person(name = "Alex", age = 24, autos = Auto(model = "BMW", color = "black"))
        val person2 = Person(name = "Mike", age = 34, autos = Auto(model = "KIA", color = "white"))

        personRepository.saveAll(listOf(person1, person2))
        personRepository.findByNameAndAge("Alex", 24)

        val resultAll = personRepository.findAllById(listOf(3, 4, 5))
        println(resultAll)

        personRepository.findByNameAndAutos("Mike", Auto(model = "KIA", color = "white"))
        personRepository.deleteById(1)

        val betweenAges = personRepository.findPersonByAgeIsBetween(24, 36)
        println(betweenAges)


    }
}

fun main(args: Array<String>) {
    runApplication<Main>(*args)
}

