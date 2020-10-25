package com.musicapp.service

import com.musicapp.dao.UserDaoImpl

object UserServiceImpl: UserService {

    val userDao = UserDaoImpl

    override fun addDetails(userId: String, userName: String, userPassword: String) {
        userDao.addDetails(userId, userName, userPassword)
    }

    override fun checkDetails(userdId: String, password: String): Boolean {
        val check = userDao.checkDetails(userdId, password)
        return check
    }

    override fun updatePassword(newPassword: String, userId: String) {
        userDao.updatePassword(newPassword, userId)
    }

    override fun updateUserName(newName: String, userId: String) {
        userDao.updateUserName(newName, userId)
    }

    override fun deleteAccount(userId: String) {
        userDao.deleteAccount(userId)
    }

}