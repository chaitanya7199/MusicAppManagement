package com.musicapp.model

class User(userId: String, userName: String, userPassword: String) {

    var userId: String
        get() = this.userId
        set(userId) { this.userId = userId }

    var userName: String
        get() = this.userName
        set(userName) { this.userName = userName }

    var userPassword: String
        get() = this.userPassword
        set(userPassword) { this.userPassword = userPassword }

}