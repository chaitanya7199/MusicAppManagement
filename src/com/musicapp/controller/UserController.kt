package com.musicapp.controller

import com.musicapp.dao.UserDaoImpl
import com.musicapp.model.User
import com.musicapp.service.UserServiceImpl


class UserController {

    val userService = UserServiceImpl
    val musicStoreController = MusicStoreController()
    val userWishlistController = UserWishlistController()

    fun addDetails(userId: String, userName: String, userPassword: String) {
        val user = User(userId, userName, userPassword)
        userService.addDetails(userId, userName, userPassword)
    }

    fun checkDetails(userdId: String, password: String): Boolean {
        var detailsCheck = userService.checkDetails(userdId, password)
        return detailsCheck
    }

    fun updatePassword(newPassword: String, userId: String) {
        userService.updatePassword(newPassword, userId)
    }

    fun updateUserName(newName: String, userId: String) {
        userService.updateUserName(newName, userId)
    }

    fun deleteAccount(userId: String) {
        userService.deleteAccount(userId)
    }

    fun displaySongByTitle(songTitle: String) {
        musicStoreController.displaySongByTitle(songTitle)
    }

    fun displaySongByAlbum(albumName: String) {
        musicStoreController.displaySongByAlbum(albumName)
    }

    fun displaySongBySinger(singer: String) {
        musicStoreController.displaySongBySinger(singer)
    }

    fun displayAll() {
        musicStoreController.displayAll()
    }

    fun addSongToWishlist(songTitle: String, userId: String) {
        userWishlistController.addToWishlist(songTitle, userId)
    }

    fun deleteFromWishlist(title: String) {
        userWishlistController.deleteSongFromWishlist(title)
    }

    fun displayAllFromWishlist() {
        userWishlistController.displayAllFromWishlist()
    }

    fun displaySongByTitleFromWishlist(songTitle: String) {
        userWishlistController.displaySongByTitleFromWishlist(songTitle)
    }

    fun displaySongByAlbumFromWishlist(albumName: String) {
        userWishlistController.displaySongByAlbumFromWishlist(albumName)
    }

    fun displaySongBySingerFromWishlist(singer: String) {
        userWishlistController.displaySongBySingerFromWishlist(singer)
    }

}