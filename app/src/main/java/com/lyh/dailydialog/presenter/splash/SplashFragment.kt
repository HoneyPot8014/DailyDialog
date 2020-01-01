package com.lyh.dailydialog.presenter.splash


import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import com.lyh.dailydialog.R
import com.lyh.dailydialog.presenter.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    private val showAnimatorSet = AnimatorSet()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val splashAnimator = ValueAnimator.ofFloat(0.9f, 1.1f).apply {
            addUpdateListener {
                splash_logo.scaleX = it.animatedValue as Float
                splash_logo.scaleY = it.animatedValue as Float
            }
            duration = 500
            interpolator = AccelerateInterpolator()
        }

        showAnimatorSet.apply {
            play(splashAnimator).with(splash_emoticon.animatorSet)
            start()
        }
    }

    fun stopAnimation() {
        showAnimatorSet.end()
    }
}
