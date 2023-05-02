package com.example.kotlin.MVP.Contract

import com.example.kotlin.MVP.Model.User

interface LoginContract {
    interface View {
        fun loginSuccess(   id:Int)
        fun loginError(message: String)


    }

    interface Persenter{
        fun login (user: User)

    }
}