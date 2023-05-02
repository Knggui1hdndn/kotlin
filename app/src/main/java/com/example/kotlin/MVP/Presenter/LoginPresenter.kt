package com.example.kotlin.MVP.Presenter


import android.util.Log
import com.example.kotlin.MVP.API.ApiLogin
import com.example.kotlin.MVP.Contract.LoginContract
import com.example.kotlin.MVP.Model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginPresenter(var presenter: LoginContract.View) : LoginContract.Persenter {

    override fun login(user: User) {
        val rs: String = user.validate()
        if (rs == "Login thành công") {
            getData(user)
        } else {
            presenter.loginError(rs)
        }

    }

    private fun getData(user: User) {
        ApiLogin.apiLogin.getUser(user.name, user.password).enqueue(object :  Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    Log.d("aaaaaaaa","ok"+ (response.body()   ))
                    response.body()?.let {
                        it[0].id?.let { it1 -> presenter.loginSuccess(it1) }
                    }
                } else {
                    presenter.loginError(response.message())
                    Log.d("aaaaaaaa","ok1"+response.message())

                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.message?.let { presenter.loginError(it) }

            }
        }
        )
    }

}