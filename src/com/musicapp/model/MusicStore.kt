package com.musicapp.model

class MusicStore(songId: String, songTitle: String, singer: String, albumName: String) {

    var songId: String
        get() = this.songId
        set(songId) { this.songId = songId }

    var songTitle: String
        get() = this.songTitle
        set(songTitle) { this.songTitle = songTitle }

    var singer: String
        get() = this.singer
        set(singer) { this.singer = singer }

    var albumName: String
        get() = this.albumName
        set(albumName) { this.albumName = albumName }
}