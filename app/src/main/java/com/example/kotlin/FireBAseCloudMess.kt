package com.example.kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import com.example.kotlin.MVP.View.TaoQR
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FireBAseCloudMess : FirebaseMessagingService() {
    @SuppressLint("SuspiciousIndentation")
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("dataaaa", "onMessageReceived: ")
//        val i = Intent(applicationContext, TaoQR::class.java)
//        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//        applicationContext.startActivity(i)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("sssssssssss", "onNewToken"+token)
    }

}