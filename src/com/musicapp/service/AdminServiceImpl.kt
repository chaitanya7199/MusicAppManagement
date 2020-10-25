package com.musicapp.service

import com.musicapp.dao.AdminDaoImpl

object AdminServiceImpl: AdminService {

    val adminDao = AdminDaoImpl
    
    override fun checkDetails(id: String, pass: String): Boolean {
        val check = adminDao.checkDetails(id, pass)
        return check
    }

    override fun addSong(id: String, title: String, singer: String, album: String, url: String) {
        adminDao.addSong(id, title, singer, album, url)
    }

    override fun removeSong(songId: String) {
        adminDao.removeSong(songId)
    }

    override fun updateTitle(newTitle: String, songId: String) {
        adminDao.updateTitle(newTitle, songId)
    }

    override fun updateSinger(singer: String, songId: String) {
        adminDao.updateSinger(singer, songId)
    }

    override fun updateAlbum(album: String, songId: String) {
        adminDao.updateAlbum(album, songId)
    }

    override fun updateUrl(url: String, songId: String) {
        adminDao.updateUrl(url, songId)
    }

    override fun updatePassword(newPassword: String, adminId: String) {
        adminDao.updatePassword(newPassword, adminId)
    }

}