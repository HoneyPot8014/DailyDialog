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

    companion object {
        val TAG = this::class.java.name
    }

    val endAnimationSet = AnimatorSet()
    private val animatorSet = AnimatorSet()

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

        val endSplashAnimator = ValueAnimator.ofFloat(1f, 0f).apply {
            addUpdateListener {
                splash_logo.alpha = it.animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
        }

        animatorSet.apply {
            play(splashAnimator).with(splash_emoticon.animatorSet)
            start()
        }

        endAnimationSet.apply {
            play(endSplashAnimator).with(splash_emoticon.endIconAnimator)
            duration = 300
        }
    }
}
