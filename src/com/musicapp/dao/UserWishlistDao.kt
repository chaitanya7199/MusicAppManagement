package com.musicapp.dao

interface UserWishlistDao {

    fun addSongToWishlist(songTitle: String, userId: String)
    fun deleteSongFromWishlist(title: String)
    fun displaySongByTitleFromWishlist(songTitle: String)
    fun displaySongBySingerFromWishlist(singer: String)
    fun displayAllFromWishlist()
    fun displaySongByAlbumFromWishlist(albumName: String)

}