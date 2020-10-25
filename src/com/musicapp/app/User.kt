package com.musicapp.app

import com.musicapp.controller.UserController
import java.util.*

fun main() {

    val sc = Scanner(System.`in`)
    val userController = UserController()
    var choice: Int

    firstWhile@
    do {
        println("1. User Registration")
        println("2. User Login")
        println("3. Exit")
        println("Enter your choice:")
        choice = sc.nextInt()
        sc.nextLine()

        if (choice == 1) {
            println("Enter the details of the user :")
            println("Enter userId: ")
            var userId = sc.nextLine();
            while (userId.length > 4 || userId.length < 3) {
                println("User ID should be minimum of 3 characters and maximum of 4 characters.")
                println("Enter userId: ")
            }
            println("Enter name: ")
            var userName = sc.nextLine();
            println("Enter password: ")
            var userPassword = sc.nextLine();
            val pattern1 = Regex("[A-Z]")
            val pattern2 = Regex("[$%&@#]")
            while (userPassword.length != 8 || !pattern1.containsMatchIn(userPassword) || !pattern2.containsMatchIn(userPassword)) {
                println("Password should be 8 characters long with one upper case and one special character.")
                println("Enter password: ")
                userPassword = sc.nextLine();
            }
            userController.addDetails(userId, userName, userPassword)
        } else if(choice==2){
            println("Enter UserId:")
            var userId = sc.nextLine()
            println("Enter Password:")
            var pass = sc.nextLine()
            var detailsVerification: Boolean = userController.checkDetails(userId, pass)
            if (detailsVerification == false) {
                println("Wrong credentials.\nIf not resistered, choose option 1 for registration.")
            } else {
                println("LoggedIn successfully.")

                do {
                    println("1. Display all songs from music store.")
                    println("2. Display songs by title.")
                    println("3. Display songs by singer.")
                    println("4. Display songs by album/movie name.")
                    println("5. Add song to wishlist.")
                    println("6. Remove song from wishlist.")
                    println("7. Display all songs from wishlist.")
                    println("8. Display songs by title from wishlist.")
                    println("9. Display songs by singer from wishlist.")
                    println("10. Display songs by album/movie name from wishlist.")
                    println("11. Update User Info")
                    println("12. Delete Account")
                    println("13. Exit")

                    println("Enter your choice: ")
                    choice = sc.nextInt()
                    sc.nextLine()
                    if (choice == 1) {
                        userController.displayAll()
                    } else if (choice == 2) {
                        println("Enter the title of the song: ")
                        var title = sc.nextLine()
                        userController.displaySongByTitle(title)
                    } else if (choice == 3) {
                        println("Enter the name of the singer: ")
                        var singer = sc.nextLine()
                        userController.displaySongBySinger(singer)
                    } else if (choice == 4) {
                        println("Enter the name of the album: ")
                        var album = sc.nextLine()
                        userController.displaySongByAlbum(album)
                    } else if (choice == 5) {
                        println("Enter the title of the song to add to wishlist: ")
                        var title = sc.nextLine()
                        userController.addSongToWishlist(title, userId)
                    } else if (choice == 6) {
                        println("Enter the title of the song to remove: ")
                        var title = sc.nextLine()
                        userController.deleteFromWishlist(title)
                    } else if (choice == 7) {
                        userController.displayAllFromWishlist()
                    } else if (choice == 8) {
                        println("Enter the title of the song to remove: ")
                        var title = sc.nextLine()
                        userController.displaySongByTitleFromWishlist(title)
                    } else if (choice == 9) {
                        println("Enter the name of the singer: ")
                        var singer = sc.nextLine()
                        userController.displaySongBySingerFromWishlist(singer)
                    } else if (choice == 10) {
                        println("Enter the name of the album: ")
                        var album = sc.nextLine()
                        userController.displaySongByAlbumFromWishlist(album)
                    } else if (choice == 11) {
                        do {
                            println("1. Update password")
                            println("2. Update name")
                        } while (false)
                        println("Enter your choice: ")
                        var c = sc.nextInt()
                        sc.nextLine()
                        if (c == 1) {
                            println("Enter new password:")
                            var newPassword = sc.nextLine();
                            val pattern1 = Regex("[A-Z]")
                            val pattern2 = Regex("[$%&@#]")
                            while (newPassword.length != 8 || !pattern1.containsMatchIn(newPassword) || !pattern2.containsMatchIn(newPassword)) {
                                println("Password should be 8 characters long with atleast one upper case and one special character.")
                                println("Enter new password: ")
                                newPassword = sc.nextLine();
                            }
                            println("Reenter the password:")
                            var checkNewPassword = sc.nextLine();
                            if (newPassword.equals(checkNewPassword))
                                userController.updatePassword(newPassword, userId)
                            else {
                                println("password did not match")
                                continue
                            }
                        } else if (c == 2) {
                            println("Enter new name:")
                            var newName = sc.nextLine();
                            userController.updateUserName(newName, userId)
                        }
                    } else if (choice == 12) {
                        println("Enter the ID of the user:")
                        var userId = sc.nextLine()
                        userController.deleteAccount(userId)
                        break;
                    } else if(choice == 13){
                        break@firstWhile
                    }
                    else {
                        println("Invalid choice.\nPlease choose from above options.")
                    }
                } while (true)
            }
        }
        else if(choice==3)
            break;
        else {
            println("Invalid choice.\nPlease choose from above options.")
        }
    } while (true)
}