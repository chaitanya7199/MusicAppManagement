package com.musicapp.service

interface MusicStoreService {

    fun displayAll()
    fun displaySongByTitle(title: String)
    fun displaySongBySinger(singer: String)
    fun displaySongByAlbum(album: String)
}