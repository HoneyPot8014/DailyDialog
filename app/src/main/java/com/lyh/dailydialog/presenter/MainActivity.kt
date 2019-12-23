package com.lyh.dailydialog.presenter

import android.os.Bundle
import com.lyh.dailydialog.R
import com.lyh.dailydialog.presenter.base.BaseActivity
import com.lyh.dailydialog.util.AppContext

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppContext.init(application)

    }
}
