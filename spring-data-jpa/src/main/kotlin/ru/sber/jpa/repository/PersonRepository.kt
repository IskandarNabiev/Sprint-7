package ru.sber.jpa.repository


import Auto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.sber.jpa.entity.Person


@Repository
interface PersonRepository : CrudRepository<Person, Long> {

    fun findByNameAndAge(name: String, age: Int): List<Person>

    fun findByNameAndAutos(name: String, autos: Auto)

    fun findPersonByAgeIsBetween(age1: Int, age2: Int)


}