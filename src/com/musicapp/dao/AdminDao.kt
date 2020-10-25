package com.musicapp.dao

interface AdminDao {

    fun checkDetails(id: String, pass: String): Boolean
    fun addSong(id: String, title: String, singer: String, album: String, url: String)
    fun removeSong(songId: String)
    fun updateTitle(newTitle: String, songId: String)
    fun updateSinger(singer: String, songId: String)
    fun updateAlbum(album: String, songId: String)
    fun updateUrl(url: String, songId: String)
    fun updatePassword(newPassword: String, adminId: String)
}