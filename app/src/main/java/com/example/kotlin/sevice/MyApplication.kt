package com.example.kotlin.sevice

import android.app.Application
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentCallbacks
import android.content.ComponentName
import android.content.Context
import android.util.Log


class MyApplication : Application() {
    var isAppKilled = false
        private set

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.d("ssssss", "onTerminate")
        val cbc = ComponentName(this, MyService::class.java)
        val jobInfo: JobInfo = JobInfo.Builder(1, cbc)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE)
            .setPersisted(true)
            .build()
        val scheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
        scheduler.schedule(jobInfo)
    }


    override fun onTerminate() {
        super.onTerminate()
        isAppKilled = true
    }
}
