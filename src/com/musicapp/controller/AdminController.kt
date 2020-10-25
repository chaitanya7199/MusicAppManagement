package com.musicapp.controller

import com.musicapp.service.AdminServiceImpl
import com.musicapp.service.MusicStoreServiceImpl

class AdminController {

    val adminService = AdminServiceImpl
    val musicStoreService = MusicStoreServiceImpl

    fun displayAll() {
        musicStoreService.displayAll()
    }

    fun displaySongByTitle(title: String) {
        musicStoreService.displaySongByTitle(title)
    }

    fun displaySongBySinger(singer: String) {
        musicStoreService.displaySongBySinger(singer)
    }

    fun displaySongByAlbum(album: String) {
        musicStoreService.displaySongByAlbum(album)
    }

    fun checkDetails(id: String, pass: String): Boolean {
        val check = adminService.checkDetails(id, pass)
        return check
    }

    fun addSongToMusicStore(id: String, title: String, singer: String, album: String, url: String) {
        adminService.addSong(id, title, singer, album, url)
    }

    fun removeSongFromMusicStore(songId: String) {
        adminService.removeSong(songId)
    }

    fun updateTitle(newTitle: String, songId: String) {
        adminService.updateTitle(newTitle, songId)
    }

    fun updateSinger(singer: String, songId: String) {
        adminService.updateSinger(singer, songId)
    }

    fun updateAlbum(album: String, songId: String) {
        adminService.updateAlbum(album, songId)
    }

    fun updateUrl(url: String, songId: String) {
        adminService.updateUrl(url, songId)
    }

    fun updatePassword(newPassword: String, adminId: String) {
        adminService.updatePassword(newPassword, adminId)
    }

}

