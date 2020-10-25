package com.musicapp.service

import com.musicapp.dao.MusicStoreDaoImpl

object MusicStoreServiceImpl: MusicStoreService {

    val musicStoreDao = MusicStoreDaoImpl

    override fun displayAll() {
        musicStoreDao.displayAll()
    }

    override fun displaySongByTitle(title: String) {
        musicStoreDao.displaySongByTitle(title)
    }

    override fun displaySongBySinger(singer: String) {
        musicStoreDao.displaySongBySinger(singer)
    }

    override fun displaySongByAlbum(album: String) {
        musicStoreDao.displaySongByAlbum(album)
    }

}