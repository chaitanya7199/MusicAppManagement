package com.musicapp.dao

import com.musicapp.model.User
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

object UserDaoImpl: UserDao {

    var conn: Connection? = null

    override fun addDetails(userId: String,  userName: String, userPassword: String) {
        User(userId, userName, userPassword)
        conn = getConnection()
        var stmt: Statement? = null
        var i = 0
        try {
            stmt = conn!!.createStatement()
            if(findUser(userId)) {
                println("UserId already exists.\nPlease try again with different UserId.")
                return
            }
            var sql = "insert into users values ('$userId', '$userName', MD5('$userPassword'));"
            i = stmt.executeUpdate(sql)
            if(i>0) {
                println("Details Added.")
                return
            }
            println("Something went wrong.\nTry again.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(stmt!!, conn!!)
        }
    }

    override fun checkDetails(userId: String, password: String): Boolean {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("SELECT * FROM users WHERE USER_ID = '$userId' and USER_PASSWORD = MD5('$password');")
            if(!resultset.next()) {
                return false
            }
            return true
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(resultset!!, stmt!!, conn!!)
        }
        return false
    }

    override fun updatePassword(newPassword: String, userId: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var updated: Int? = 0
        try {
            stmt = conn!!.createStatement()
            val query: String = "update users set USER_PASSWORD = MD5('$newPassword') where USER_ID = '$userId' ;"
            updated = stmt.executeUpdate(query)
            if(updated<=0) {
                println("Updation failed.\nTry again.")
                return
            }
            println("Updation Successfully.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(stmt!!, conn!!)
        }
    }

    override fun updateUserName(newName: String, userId: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var updated: Int? = 0
        try {
            stmt = conn!!.createStatement()
            val query: String = "update users set USER_NAME = '$newName' where USER_ID = '$userId' ;"
            updated = stmt.executeUpdate(query)
            if(updated<=0) {
                println("Updation failed.\nTry again.")
                return
            }
            println("Updated Successfully.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(stmt!!, conn!!)
        }
    }

    override fun deleteAccount(userId: String) {
        conn = getConnection()
        var stmt: Statement? = null
        try {
            stmt = conn!!.createStatement()
            val sql1 = "delete from userWishlist where USER_ID = '$userId' ;"
            val sql2 = "delete from users where USER_ID = '$userId' ;"
            stmt.executeUpdate(sql1)
            var d  = stmt.executeUpdate(sql2)
            if(d<=0) {
                println("Something went wrong.\nTry again.")
                return
            }
            println("Deleted Successfully.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(stmt!!, conn!!)
        }
    }

    fun findUser(userId: String): Boolean {
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            conn = getConnection()
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("SELECT * FROM users WHERE USER_ID = '$userId';")
            if (!resultset!!.next() == false) {
                return true
            }
        } catch(ex: SQLException) {
            ex.printStackTrace()
        } finally {
            closeConnection( resultset!!, stmt!!, conn!!)
        }
        return false
    }
}