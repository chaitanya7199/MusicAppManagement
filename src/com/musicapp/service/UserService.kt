package com.musicapp.service

interface UserService {

    fun addDetails(userId: String,  userName: String, userPassword: String)
    fun checkDetails(userdId: String, password: String): Boolean
    fun updatePassword(newPassword: String, userId: String)
    fun updateUserName(newName: String, userId: String)
    fun deleteAccount(userId: String)
}