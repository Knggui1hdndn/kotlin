package com.example.kotlin.MVP.API

import android.view.ScaleGestureDetector
import com.example.kotlin.MVP.Model.Friend
import com.example.kotlin.MVP.Model.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import org.bouncycastle.math.ec.endo.ScalarSplitParameters
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import java.lang.ref.Cleaner.create


public interface ApiLogin {

    // http://192.168.1.36:3000/
    companion object {
        //https://img.vietqr.io/image/970418-12910000500686-qr_only.png?amount=100000\&addInfo=Android%20Java\&accountNguyen%20Duy%20Khang
        val gson: Gson = GsonBuilder().setDateFormat("yyyyy-MM-dd").create()
        val apiLogin: ApiLogin = Retrofit.Builder().baseUrl("https://fcm.googleapis.com/fcm/")
            .addConverterFactory(ScalarsConverterFactory.create()).build()
            .create(ApiLogin::class.java)

    }

    @POST("send")
    fun post(@HeaderMap map: MutableMap<String, String>, @Body string: String): Call<String>

    @GET("users")
    fun getListUser(): Call<List<User?>?>?

    @GET("users")
    fun getUser(@Query("name") name: String, @Query("password") password: String): Call<List<User>>

    @GET("users/{id}")
    fun getUserID(@Path("id") name: Int): Call<User>

    @POST("/User")
    fun addUser(@Body address: User?): Call<User?>?

    @PUT("/User/{id}")
    fun updateUser(@Path("id") id: Long, @Body address: User?): Call<User>?

    @DELETE("/User/{id}")
    fun deleteUser(@Path("id") id: Long): Call<Void?>?

    @PATCH("users/friends")
    fun addFriends(@Query("id") id: Long, @Body address: MutableList<Friend>): Call<User>
}