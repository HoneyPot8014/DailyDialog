package com.lyh.dailydialog.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lyh.dailydialog.R
import com.lyh.dailydialog.data.api.emotion.EmotionRequest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EmotionRequest.Builder.setContent("no").build()
    }
}
