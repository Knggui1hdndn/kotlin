package com.example.kotlin.MVP.Presenter

import com.example.kotlin.MVP.API.ApiQR
import com.example.kotlin.MVP.Contract.QRContract
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QrPresenter(val qrview:QRContract.View) :QRContract.Persenter {
    override fun getImgQr(
        BIN: String,
        stk: String,
        amount: String,
        mota: String,
        name: String
    ) {
         ApiQR.apiQR.getIMG(BIN,stk,amount,mota,name).enqueue(object :Callback<ResponseBody>{
             override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                 t.message?.let { qrview.callError(it) }
              }

             override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    val inputStream=response.body()?.byteStream()

                    if (inputStream != null) {
                        qrview.callSuccess(inputStream)
                    }
                }else{
                    qrview.callError(response.message())
                }
             }
         }
         )
    }

}