package com.lyh.dailydialog.util

import android.app.Application

object AppContext {

    lateinit var context: Application

    fun init(application: Application) {
        context = application
    }

}