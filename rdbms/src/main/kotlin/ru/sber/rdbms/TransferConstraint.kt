package ru.sber.rdbms

import java.sql.DriverManager

class TransferConstraint {
    fun transfer(accountId1: Long, accountId2: Long, amount: Long) {
        val connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/db",
            "postgres",
            "postgres"
        )
        connection.use { conn ->
            val withdraw = conn.prepareStatement("update account set amount = amount - ? where id = ?;")
            withdraw.use { statement ->
                statement.setLong(1, amount)
                statement.setLong(2, accountId1)
                statement.executeUpdate()
                }

            val addMoney = conn.prepareStatement("update account set amount = amount + ? where id = ?;")
            addMoney.use { statement ->
                statement.setLong(1, amount)
                statement.setLong(2, accountId2)
                statement.executeUpdate()
            }
        }
    }
}

