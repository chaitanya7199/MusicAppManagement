package com.musicapp.service

import com.musicapp.dao.UserWishlistDaoImpl

object UserWishlistServiceImpl: UserWishlistService {

    val userWishlistDao = UserWishlistDaoImpl

    override fun addSongToWishlist(songTitle: String, userId: String) {
        userWishlistDao.addSongToWishlist(songTitle, userId)
    }

    override fun deleteSongFromWishlist(title: String) {
        userWishlistDao.deleteSongFromWishlist(title)
    }

    override fun displaySongByTitleFromWishlist(songTitle: String) {
        userWishlistDao.displaySongByTitleFromWishlist(songTitle)
    }

    override fun displaySongByAlbumFromWishlist(albumName: String) {
        userWishlistDao.displaySongByAlbumFromWishlist(albumName)
    }

    override fun displaySongBySingerFromWishlist(singer: String) {
        userWishlistDao.displaySongBySingerFromWishlist(singer)
    }

    override fun displayAllFromWishlist() {
        userWishlistDao.displayAllFromWishlist()
    }

}