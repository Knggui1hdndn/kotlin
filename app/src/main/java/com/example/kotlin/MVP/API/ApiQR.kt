package com.example.kotlin.MVP.API

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiQR {
    companion object  {
        //https://img.vietqr.io/image/970418-12910000500686-qr_only-2R0jY5w.png?amount=100000\&addInfo=Android%20Java\&accountNguyen%20Duy%20Khang
        val gson: Gson
                = GsonBuilder().setDateFormat("yyyyy-MM-dd").create()

        val apiQR: ApiQR
                = Retrofit.Builder().baseUrl("https://img.vietqr.io/image/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
            .create(ApiQR::class.java)
    }
    //qr_only print
    @GET("{BIN}-{stk}-2R0jY5w.png")
    fun getIMG(@Path("BIN") BIN: String,
               @Path("stk") stk: String,
               @Query("amount") amount: String,
               @Query("addInfo") mota: String,
               @Query("account") name: String): Call<ResponseBody>
}