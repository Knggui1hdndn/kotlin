package com.example.kotlin.MVP.Contract

import com.example.kotlin.MVP.Model.Friend
import com.example.kotlin.MVP.Model.User

interface ShowContract {
    interface View{
        fun addSuccess(friend: Friend)
        fun addError(mes:String)
        fun showContentSuccess(user: User)
        fun showContentError(mes:String)

    }
    interface Persenter{

        fun getInfoUsersLogin(id:Int)
        fun addFriends(id: Long,friend: Friend)
    }
}