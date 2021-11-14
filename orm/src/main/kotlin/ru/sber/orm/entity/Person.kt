package ru.sber.orm.entity

import javax.persistence.*


@Entity
class Person(

    @Id
    @GeneratedValue
    var id: Long = 0,

    var name: String,
    var age: Int,

    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "person")
    var autos: Auto



) {
    override fun toString(): String {
        return "Person(id=$id, name='$name', age=$age, autos=$autos)"
    }
}