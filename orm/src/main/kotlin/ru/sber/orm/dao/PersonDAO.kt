package ru.sber.orm.dao

import org.hibernate.SessionFactory
import ru.sber.orm.entity.Person



class PersonDAO (private val sessionFactory: SessionFactory) {

    fun findById(id: Long): Person? {
        val result: Person?
        sessionFactory.openSession().use { session ->
            session.beginTransaction()
            result = session.get(Person::class.java, id)
            session.transaction.commit()
        }
        return result
    }

    fun save(user: Person) {
       sessionFactory.openSession().use { session ->
           session.beginTransaction()
           session.save(user)
           session.transaction.commit()
       }
    }

    fun update(user: Person) {
        sessionFactory.openSession().use { session ->
            session.beginTransaction()
            session.update(user)
            session.transaction.commit()
        }
    }

    fun delete(id: Long) {
        sessionFactory.openSession().use { session ->
            session.beginTransaction()
            session.delete(id)
            session.transaction.commit()
        }
    }

    fun findAll(): MutableList<Person> {
        val result: MutableList<Person>
        sessionFactory.openSession().use { session ->
            session.beginTransaction()
            result = session.createQuery("from Person").list() as MutableList<Person>
            session.transaction.commit()
        }
        return result
    }


}