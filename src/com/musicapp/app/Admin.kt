package com.musicapp.app

import com.musicapp.controller.AdminController
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    println("Enter credentials:")
    println("Enter ID:")
    var adminId = sc.nextLine()
    println("Enter password:")
    var pass = sc.nextLine()

    val adminController = AdminController()
    var check = adminController.checkDetails(adminId, pass)
    if(check==false) {
        println("Wrong credentials")
        return
    }
    println("Access Granted")

    do {
        println("1. Display all songs from music store.")
        println("2. Display songs by title.")
        println("3. Display songs by singer.")
        println("4. Display songs by album/movie name.")
        println("5. Add song to the music store.")
        println("6. Update the song details.")
        println("7. Remove the song from music store.")
        println("8. Update Password")
        println("9. Exit")

        println("Enter your choice: ")
        var choice = sc.nextInt()
        sc.nextLine()
        if (choice == 1) {
            adminController.displayAll()
        } else if (choice == 2) {
            println("Enter the title of the song: ")
            var title = sc.nextLine()
            adminController.displaySongByTitle(title)
        } else if (choice == 3) {
            println("Enter the name of the singer: ")
            var singer = sc.nextLine()
            adminController.displaySongBySinger(singer)
        } else if (choice == 4) {
            println("Enter the name of the album: ")
            var album = sc.nextLine()
            adminController.displaySongByAlbum(album)
        } else if (choice == 5) {
            println("Enter song details:")
            println("Enter song id: ")
            var id = sc.nextLine()
            println("Enter song title:")
            var title = sc.nextLine()
            println("Enter the name of the singer:")
            var singer = sc.nextLine()
            println("Enter the album or movie name:")
            var album = sc.nextLine()
            println("Enter the url for the video:")
            var url = sc.nextLine()
            adminController.addSongToMusicStore(id, title, singer, album, url)

        } else if (choice == 6) {
            var c = 5
            println("Enter the song id you want to update:")
            var songId = sc.nextLine()
            do {
                println("1. Update title")
                println("2. Update singer name")
                println("3. Update album name")
                println("4. Update video url")
                println("5. Exit")
                println("Enter your choice: ")
                c = sc.nextInt()
                sc.nextLine()

                if (c == 1) {
                    println("Enter new title:")
                    var newTitle = sc.nextLine();
                    adminController.updateTitle(newTitle, songId)
                } else if (c == 2) {
                    println("Enter name of the singer:")
                    var singer = sc.nextLine();
                    adminController.updateSinger(singer, songId)
                } else if (c == 3) {
                    println("Enter name of the album:")
                    var album = sc.nextLine();
                    adminController.updateAlbum(album, songId)
                } else if (c == 4) {
                    println("Enter the url:")
                    var url = sc.nextLine();
                    adminController.updateUrl(url, songId)
                }
            } while (c != 5)
        }else if (choice == 7) {
            println("Enter the id of the song to be removed:")
            val songId = sc.nextLine()
            adminController.removeSongFromMusicStore(songId)
        }
        else if(choice == 8) {
            println("Enter new password:")
            var newPassword = sc.nextLine();
            val pattern1 = Regex("[A-Z]")
            val pattern2 = Regex("[$%&@#]")
            while(newPassword.length!=8 || !pattern1.containsMatchIn(newPassword) || !pattern2.containsMatchIn(newPassword)) {
                println("Password should be 8 characters long with atleast one upper case and one special character.")
                println("Enter new password: ")
                newPassword = sc.nextLine();
            }
            println("Reenter the password:")
            var checkNewPassword = sc.nextLine();
            if (newPassword.equals(checkNewPassword))
                adminController.updatePassword(newPassword, adminId)
            else
                println("password did not match")
        }
    } while (choice != 9)
}