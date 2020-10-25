package com.musicapp.dao

interface MusicStoreDao {

    fun displaySongByTitle(songTitle: String)
    fun displaySongBySinger(singer: String)
    fun displayAll()
    fun displaySongByAlbum(albumName: String)
}