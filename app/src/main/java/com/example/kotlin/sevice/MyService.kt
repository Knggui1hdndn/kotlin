package com.example.kotlin.sevice

import android.app.Service
import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi

class MyService : JobService() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.d("MyApp", "startJob")
        val broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(applicationContext, "Quá tuyệt zời", Toast.LENGTH_SHORT).show()
                Log.d("MyApp", "Received message: ")
            }
        }
        val intentFilter = IntentFilter("com.google.android.c2dm.intent.RECEIVE")
        intentFilter.addCategory("com.example.kotlin")
        applicationContext.registerReceiver(broadcastReceiver, intentFilter)

        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("MyApp", "stopJob")

        return true
    }


}