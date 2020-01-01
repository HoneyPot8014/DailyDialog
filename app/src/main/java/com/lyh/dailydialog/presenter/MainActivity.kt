package com.lyh.dailydialog.presenter

import android.os.Bundle
import android.view.View
import androidx.core.animation.doOnEnd
import com.lyh.dailydialog.R
import com.lyh.dailydialog.presenter.base.BaseActivity
import com.lyh.dailydialog.presenter.splash.SplashFragment
import com.lyh.dailydialog.util.AppContext
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppContext.init(application)
        showSplash()

    }

    private fun showSplash() {
        bottom_nav.visibility = View.GONE
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.v_container, SplashFragment(), SplashFragment.TAG)
            .commit()
    }

    private fun hideSplash() {
        (supportFragmentManager.findFragmentByTag(SplashFragment.TAG) as? SplashFragment)?.let { splashFragment ->
            splashFragment.endAnimationSet.apply {
                doOnEnd {
                    bottom_nav.visibility = View.VISIBLE
                    supportFragmentManager
                        .beginTransaction()
                        .remove(splashFragment)
                        .commit()
                }
                start()
            }
        }
    }
}
