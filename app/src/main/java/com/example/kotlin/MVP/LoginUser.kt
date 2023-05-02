package com.example.kotlin.MVP

import android.os.Environment
import java.io.File

data class LoginUser(val username: String, val password: String){
    fun login(callback: (Boolean) -> Int) {
        // Xử lý đăng nhập
        val success = (username == "admin" && password == "admin")
        callback(success)
    }

}
