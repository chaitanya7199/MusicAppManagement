package com.musicapp.dao

import java.sql.*

object UserWishlistDaoImpl: UserWishlistDao {

    var conn: Connection? = null

    override fun addSongToWishlist(songTitle: String, userId: String) {
        conn = getConnection()
        var pStmt: PreparedStatement? = null
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("select * from musicstore where SONG_TITLE LIKE '%$songTitle%' ;")
            if (!resultset.next()) {
                println("Song with title $songTitle not found in music store.")
                return
            }
            var userId = userId
            var songId = resultset.getString(1)
            var songTitle = resultset.getString(2)
            var singer = resultset.getString(3)
            var album = resultset.getString(4)
            pStmt = conn!!.prepareStatement("insert into userWishlist values(?, ?, ?, ?, ?);")
            pStmt.setString(1, userId)
            pStmt.setString(2, songId)
            pStmt.setString(3, songTitle)
            pStmt.setString(4, singer)
            pStmt.setString(5, album)
            pStmt.executeUpdate()
            println("Song added to wishlist.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(resultset!!, stmt!!, conn!!)
        }
    }

    override fun deleteSongFromWishlist(title: String) {
        conn = getConnection()
        var stmt: Statement? = null
        try {
            stmt = conn!!.createStatement()
            val sql = "delete from userWishlist where SONG_TITLE LIKE '%$title%' ;"
            var d = stmt.executeUpdate(sql)
            if (d > 0) {
                println("Removed Successfully.")
                return
            }
            println("Failed.\nRetry.")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(stmt!!, conn!!)
        }
    }

    override fun displaySongByTitleFromWishlist(songTitle: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("select * from userWishlist where SONG_TITLE LIKE '%$songTitle%' ;")
            if (!resultset.next()) {
                println("$songTitle is not available.")
                return
            }
            val rsmd: ResultSetMetaData = resultset.getMetaData() as ResultSetMetaData
            printSongDetails(resultset, rsmd)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(resultset!!, stmt!!, conn!!)
        }
    }

    override fun displaySongBySingerFromWishlist(singer: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("select * from userWishlist where SINGER LIKE '%$singer%' ;")
            if (!resultset.next()) {
                println("Songs by this $singer are not available.")
                return
            }
            val rsmd: ResultSetMetaData = resultset.getMetaData() as ResultSetMetaData
            printSongDetails(resultset, rsmd)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(resultset!!, stmt!!, conn!!)
        }
    }

    override fun displayAllFromWishlist() {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("select * from userWishlist;")
            if (!resultset.next()) {
                println("No songs to display.")
                return
            }
            val rsmd: ResultSetMetaData = resultset.getMetaData() as ResultSetMetaData
            printSongDetails(resultset, rsmd)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(resultset!!, stmt!!, conn!!)
        }
    }

    override fun displaySongByAlbumFromWishlist(albumName: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("select * from userWishlist where ALBUM_NAME LIKE '%$albumName%' ;")
            if (!resultset.next()) {
                println("$albumName is not available.")
                return
            }
            val rsmd: ResultSetMetaData = resultset.getMetaData() as ResultSetMetaData
            printSongDetails(resultset, rsmd)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            closeConnection(resultset!!, stmt!!, conn!!)
        }
    }
}

