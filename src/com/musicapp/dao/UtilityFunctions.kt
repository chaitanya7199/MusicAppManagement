package com.musicapp.dao

import java.sql.*
import java.util.*

/**
 * This method makes a connection to MySQL Server
 * In this example, MySQL Server is running in the local host (so 127.0.0.1)
 * at the standard port 3306
 */
fun getConnection(): Connection? {
    var conn: Connection
    var username = "root" // provide the username
    var password = "" // provide the corresponding password
    val connectionProps = Properties()
    connectionProps.put("user", username)
    connectionProps.put("password", password)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance()
        conn = DriverManager.getConnection(
            "jdbc:" + "mysql" + "://" + "localhost:3306/practice_db",
            connectionProps)
        return conn
    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }
    return null
}

fun closeConnection( resultset: ResultSet? = null, stmt: Statement, conn: Connection) {
    // release resources
    if (resultset != null) {
        try {
            resultset.close()
        } catch (sqlEx: SQLException) {
        }
    }
    closeConnection(stmt,conn)
}

fun closeConnection(stmt: Statement,conn:Connection) {
    if (stmt != null) {
        try {
            stmt.close()
        } catch (sqlEx: SQLException) {
        }
    }
    if (conn != null) {
        try {
            conn!!.close()
        } catch (sqlEx: SQLException) {
        }
    }
}

fun printSongDetails(resultset: ResultSet, rsmd: ResultSetMetaData) {
    val columnsNumber: Int = rsmd.getColumnCount()
    for (i in 1..columnsNumber) {
        if (i > 1) print(",          ")
        if (rsmd != null) {
            print(rsmd.getColumnName(i))
        }
    }
    do {
        println("")
        for (i in 1..columnsNumber) {
            if (i > 1) print(",       ")
            print(resultset.getString(i))
        }
        println("")
    }while((resultset.next()))
}
