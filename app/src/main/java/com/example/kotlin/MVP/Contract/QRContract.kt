package com.example.kotlin.MVP.Contract

import com.example.kotlin.MVP.Model.User
import retrofit2.http.Path
import java.io.InputStream

interface QRContract {
    interface View {
        fun callSuccess(inputStream: InputStream)
        fun callError(message: String)


    }

    interface Persenter {
        fun getImgQr(
            BIN: String,
            stk: String,
            amount: String,
            mota: String,
            name: String
        )

    }
}