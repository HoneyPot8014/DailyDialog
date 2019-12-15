package com.lyh.dailydialog.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lyh.dailydialog.R
import com.lyh.dailydialog.util.AppContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppContext.init(application)

    }
}
