package ru.sber.orm

import org.hibernate.cfg.Configuration
import ru.sber.orm.dao.PersonDAO
import ru.sber.orm.entity.Auto
import ru.sber.orm.entity.Person

fun main() {
    val sessionFactory = Configuration().configure()
        .addAnnotatedClass(Person::class.java)
        .addAnnotatedClass(Auto::class.java)
        .buildSessionFactory()

    sessionFactory.use { sessionFactory ->
        val personDAO = PersonDAO(sessionFactory)

        val person1 = Person(
            name = "Alex",
            age = 24,
            autos = Auto(model = "BMW", color = "black")
        )

        val person2 = Person(
            name = "Mike",
            age = 34,
            autos = Auto(model = "KIA", color = "white")
        )


        personDAO.save(person1)
        personDAO.save(person2)

        val found = personDAO.findById(person1.id)
        println("Found person: $found")

        personDAO.update(person2)
        personDAO.delete(person1.id)

        val allPersons = personDAO.findAll()
        println("All persons: $allPersons")


    }
}

