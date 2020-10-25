package com.musicapp.dao
import java.sql.*

object AdminDaoImpl: AdminDao {

    var conn: Connection? = null

    override fun checkDetails(id: String, pass: String): Boolean {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("SELECT * FROM admins WHERE ADMIN_ID = '$id' and ADMIN_PASSWORD = MD5('$pass');")
            if(!resultset.next()) {
                return false
            }
            return true
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            closeConnection(resultset!!, stmt!!, conn!!)
        }
        return false
    }

    override fun addSong(id: String, title: String, singer: String, album: String, url: String) {
        conn = getConnection()
        var stmt: PreparedStatement? = null
        var resultset: ResultSet? = null
        var i = 0
        try {
            stmt = conn!!.prepareStatement("insert into musicstore values (?, ?, ?, ?, ?);")
            stmt.setString(1, id)
            stmt.setString(2, title)
            stmt.setString(3, singer)
            stmt.setString(4, album)
            stmt.setString(5, url)

            i = stmt.executeUpdate()
            if(i>0) {
                println("Song added successfully.")
                return
            }
            println("Something failed.\nTry again.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(resultset!!, stmt!!, conn!!)
        }
    }

    override fun removeSong(songId: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            val sql = "delete from musicstore where SONG_ID = '$songId' ;"
            val d = stmt.executeUpdate(sql)

            if(d!=1) {
                println("Deletion failed.\nTry again.")
                return
            }
            println("Song is removed from music store.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(resultset!!, stmt!!, conn!!)
        }
    }

    override fun updateTitle(newTitle: String, songId: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var updated: Int? = 0
        try {
            stmt = conn!!.createStatement()
            val query: String = "update musicstore set SONG_TITLE = '$newTitle' where SONG_ID = '$songId' ;"
            updated = stmt.executeUpdate(query)
            if(updated==0) {
                println("Updation failed.\nTry Again.")
                return
            }
            println("Title Updated.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(stmt!!, conn!!)
        }
    }

    override fun updateSinger(singer: String, songId: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var updated: Int? = 0
        try {
            stmt = conn!!.createStatement()
            val query: String = "update musicstore set SINGER = '$singer' where SONG_ID = '$songId' ;"
            updated = stmt.executeUpdate(query)
            if(updated==0) {
                println("Updation failed.\nTry Again.")
                return
            }
            println("Singer Updated.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(stmt!!, conn!!)
        }
    }

    override fun updateAlbum(album: String, songId: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var updated: Int? = 0
        try {
            stmt = conn!!.createStatement()
            val query: String = "update musicstore set ALBUM_NAME = '$album' where SONG_ID = '$songId' ;"
            updated = stmt.executeUpdate(query)
            if(updated==0) {
                println("Updation failed.\nTry Again.")
                return
            }
            println("Album name Updated.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(stmt!!, conn!!)
        }
    }

    override fun updateUrl(url: String, songId: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var updated: Int? = 0
        try {
            stmt = conn!!.createStatement()
            val query: String = "update musicstore set SONG_URL = '$url' where SONG_ID = '$songId' ;"
            updated = stmt.executeUpdate(query)
            if(updated==0) {
                println("Updation failed.\nTry Again.")
                return
            }
            println("URL Updated.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(stmt!!, conn!!)
        }
    }

    override fun updatePassword(newPassword: String, adminId: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var updated: Int? = 0
        try {
            stmt = conn!!.createStatement()
            val query: String = "update admins set ADMIN_PASSWORD = '$newPassword' where ADMIN_ID = '$adminId' ;"
            updated = stmt.executeUpdate(query)
            if(updated==0) {
                println("Updation failed.\nTry again.")
                return
            }
            println("Password Updated.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(stmt!!, conn!!)
        }
    }
}