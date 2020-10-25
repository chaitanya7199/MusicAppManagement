package com.musicapp.controller

import com.musicapp.service.UserWishlistServiceImpl


class UserWishlistController {

    val userWishlistService = UserWishlistServiceImpl

    fun addToWishlist(songTitle: String, userId: String) {
        userWishlistService.addSongToWishlist(songTitle, userId)
    }

    fun deleteSongFromWishlist(title: String) {
        userWishlistService.deleteSongFromWishlist(title)
    }

    fun displaySongByTitleFromWishlist(songTitle: String) {
        userWishlistService.displaySongByTitleFromWishlist(songTitle)
    }

    fun displaySongByAlbumFromWishlist(albumName: String) {
        userWishlistService.displaySongByAlbumFromWishlist(albumName)
    }

    fun displaySongBySingerFromWishlist(singer: String) {
        userWishlistService.displaySongBySingerFromWishlist(singer)
    }

    fun displayAllFromWishlist() {
        userWishlistService.displayAllFromWishlist()
    }
}