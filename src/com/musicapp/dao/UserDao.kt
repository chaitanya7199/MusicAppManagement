package com.musicapp.dao

interface UserDao {

    fun addDetails(userId: String, userPassword: String, userName: String)
    fun checkDetails(userId: String, password: String): Boolean
    fun updatePassword(newPassword: String, userId: String)
    fun updateUserName(newName: String, userId: String)
    fun deleteAccount(userId: String)
}