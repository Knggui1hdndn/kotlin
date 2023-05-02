package com.example.kotlin.MVP.Presenter

import android.util.Log
import com.example.kotlin.MVP.API.ApiLogin
import com.example.kotlin.MVP.Contract.ShowContract
import com.example.kotlin.MVP.Model.Friend
import com.example.kotlin.MVP.Model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Main2Presenter(val view: ShowContract.View) : ShowContract.Persenter {

    override fun getInfoUsersLogin(id: Int) {
        ApiLogin.apiLogin.getUserID(id).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Log.d("aaaaaaaa", "ok" + (response.body()))
                    response.body()?.let {
                        view.showContentSuccess(it )
                    }
                } else {
                    view.showContentError(response.message())
                    Log.d("aaaaaaaa", "ok" + response.message())

                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                t.message?.let { view.showContentError(it) }

            }
        }
        )
    }

    override fun addFriends(id: Long,friends:Friend) {
        ApiLogin.apiLogin.addFriends(1, mutableListOf(friends)).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {

                    response.body()?.let {
                        view.addSuccess(friends)
                    }
                } else {
                    view.addError(response.message())
                    Log.d("aaaaaaaa", "ok" + response.message())

                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                t.message?.let { view.addError(it) }

            }
        }
        )
    }
}