package com.musicapp.controller

import com.musicapp.service.MusicStoreServiceImpl

class MusicStoreController {

    val musicStoreService = MusicStoreServiceImpl

    fun displaySongByTitle(songTitle: String) {
        musicStoreService.displaySongByTitle(songTitle)
    }

    fun displaySongByAlbum(albumName: String) {
        musicStoreService.displaySongByAlbum(albumName)
    }

    fun displaySongBySinger(singer: String) {
        musicStoreService.displaySongBySinger(singer)
    }

    fun displayAll() {
        musicStoreService.displayAll()
    }
}