package com.example.kotlin.MVP.View

import android.Manifest
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.MVP.Contract.QRContract
import com.example.kotlin.MVP.Presenter.QrPresenter
import com.example.kotlin.R
import com.example.kotlin.sevice.MyService

import kotlinx.android.synthetic.main.activity_tao_qr.*
import java.io.InputStream


class TaoQR : AppCompatActivity(), QRContract.View {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tao_qr)
        val presenter = QrPresenter(this)
        requestPermissions(arrayOf(Manifest.permission.CAMERA), 1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val pow = getSystemService(Context.POWER_SERVICE) as PowerManager
            if (!pow.isIgnoringBatteryOptimizations(packageName)) {
                val intent = Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS)
                startActivity(intent)
            }
        }


        get.setOnClickListener {
            val cbc = ComponentName(this, MyService::class.java)
            val jobInfo: JobInfo = JobInfo.Builder(1, cbc)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE)
                .setPersisted(true)
                .build()
            val scheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            scheduler.schedule(jobInfo)
        }
//
//        val notiObject = JSONObject()
//        notiObject.put("title", "sssssss")
//        notiObject.put("body", "sss")
//        val body = JSONObject()
//        body.put("data", notiObject)
//        body.put(
//            "to",
//            "cKOL4ZPFQFWdD-Ef0aidq4:APA91bGtQ-kRU8Tu30K2C5IhHOuJxb5lvGbwvwahMfbI6ps8cv2UMAL0xdyj9RkyItotSkP9hWpvfOsHr-Eu1OOn3fX2moMN4ePaToIS6DpSVdD9DzGBZq3MCx7S_n_baRMNPKWH_Wvj"
//        )
//        body.put(
//            "priority", "high"
//        )
//        ApiLogin.apiLogin.post(
//            mutableMapOf(
//                "content-type" to "application/json",
//                "authorization" to "key=AAAAOsSMB3A:APA91bHakdJnQllaTWMbrMjrQjAw0wzCThmiajn0ELUuwm92trg8rB4atp9ffTOaQV2SZEehC67Mg4L055QwmBpusvex1Jwrndaw3dIgk7lCw2SMgOIVKaFvvUfUHIafI6PHVvfwXpzB"
//            ), body.toString()
//        ).enqueue(object : Callback<String> {
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                if (response.isSuccessful) {
//                    Toast.makeText(this@TaoQR, "Response", Toast.LENGTH_SHORT).show()
//
//                } else {
//                    Log.d("sssssssss", response.body().toString())
//                }
//            }
//
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                Log.d("sssssssss", t.message + "")
//                Toast.makeText(this@TaoQR, t.message, Toast.LENGTH_SHORT).show()
//            }
//
//        })

//        edtBIN.setText("970418")
//        edtstk.setText("12910000500686")
//        edtdạng.setText("qr_only")
//        edtamount.setText("15000000")
//        edtmota.setText("Nguyen duy khang 29999")
//        edtname.setText("Nguyen Duy Khang")
//
//        //https://img.vietqr.io/image/970418-12910000500686-qr_only.png?amount=100000\&addInfo=Android%20Java\&accountNguyen%20Duy%20Khang
//
//        get.setOnClickListener {
//            var a = Comment("sss0", "ssss", "ssss", Timestamp(System.currentTimeMillis()), "s")
//
//            //    presenter.getImgQr(convertString(edtBIN),convertString(edtstk),convertString(edtamount),convertString(edtmota),convertString(edtName))
//            Firebase.database.reference.child("Messenger").push().setValue(a).addOnSuccessListener {
//                Toast.makeText(this@TaoQR, "success", Toast.LENGTH_SHORT).show()
//                Log.d("ssssss", a.toString())
//            }
//
//
//        }

    }

    private fun convertString(edtBIN: EditText?): String {
        if (edtBIN != null) {
            return edtBIN.text.toString()
        }
        return ""
    }

    override fun callSuccess(inputStream: InputStream) {
        img.setImageBitmap(BitmapFactory.decodeStream(inputStream))
    }

    override fun callError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}