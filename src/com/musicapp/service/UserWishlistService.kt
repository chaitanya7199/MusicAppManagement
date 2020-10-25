package com.musicapp.service

interface UserWishlistService {

    fun addSongToWishlist(songTitle: String, userId: String)
    fun deleteSongFromWishlist(title: String)
    fun displaySongByTitleFromWishlist(songTitle: String)
    fun displaySongByAlbumFromWishlist(albumName: String)
    fun displaySongBySingerFromWishlist(singer: String)
    fun displayAllFromWishlist()
}