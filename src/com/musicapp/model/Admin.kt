package com.musicapp.model

class Admin(adminId: String, adminPassword: String) {

    var adminId: String
        get() = this.adminId
        set(adminId) { this.adminId = adminId }

    var adminPassword: String
        get() = this.adminPassword
        set(adminPassword) { this.adminPassword = adminPassword }

}