package com.musicapp.dao

import java.sql.*

object MusicStoreDaoImpl: MusicStoreDao{

    var conn: Connection? = null

    override fun displaySongByTitle(songTitle: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("select * from musicstore where SONG_TITLE LIKE '%$songTitle%' ;")
            if(!resultset.next()) {
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

    override fun displaySongBySinger(singer: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("select * from musicstore where SINGER LIKE '%$singer%' ;")
            if(!resultset.next()) {
                println("Songs sung by $singer are not available.")
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

    override fun displayAll() {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("select * from musicstore;")
            if(!resultset.next()) {
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

    override fun displaySongByAlbum(albumName: String) {
        conn = getConnection()
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt.executeQuery("select * from musicstore where ALBUM_NAME LIKE '%$albumName%' ;")
            if(!resultset.next()) {
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