package com.lyh.dailydialog.presenter.splash


import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.lyh.dailydialog.R
import com.lyh.dailydialog.presenter.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    private val splashAnimator = ValueAnimator.ofFloat(0.9f, 1.1f)
    private val happyIconAnimator = ValueAnimator.ofFloat(0f, -60f, 0f)
    private val angryIconAnimator = ValueAnimator.ofFloat(0f, -60f, 0f)
    private val loveIconAnimator = ValueAnimator.ofFloat(0f, -60f, 0f)
    private val sadIconAnimator = ValueAnimator.ofFloat(0f, -60f, 0f)
    private val surprisedIconAnimator = ValueAnimator.ofFloat(0f, -60f, 0f)
    private val animatorSet = AnimatorSet().apply {
        play(splashAnimator)
            .with(happyIconAnimator)
            .with(angryIconAnimator)
            .with(loveIconAnimator)
            .with(sadIconAnimator)
            .with(surprisedIconAnimator)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        splashAnimator.apply {
            addUpdateListener {
                splash_logo.scaleX = it.animatedValue as Float
                splash_logo.scaleY = it.animatedValue as Float
            }

            doOnEnd {
                lifecycleScope.launch {
                    delay(5000)
                    animatorSet.end()
                    findNavController(this@SplashFragment)
                        .navigate(R.id.action_splashFragment_to_recordFragment)
                }
            }
            duration = 500
            interpolator = AccelerateInterpolator()
        }

        happyIconAnimator.apply {
            addUpdateListener {
                splash_icon_happy.translationY = animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
            repeatCount = ValueAnimator.INFINITE
            duration = 720
        }

        angryIconAnimator.apply {
            addUpdateListener {
                splash_icon_angry.translationY = animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
            repeatCount = ValueAnimator.INFINITE
            startDelay = 120
            duration = 720
        }

        loveIconAnimator.apply {
            addUpdateListener {
                splash_icon_love.translationY = animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
            repeatCount = ValueAnimator.INFINITE
            startDelay = 240
            duration = 720
        }

        sadIconAnimator.apply {
            addUpdateListener {
                splash_icon_sad.translationY = animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
            repeatCount = ValueAnimator.INFINITE
            startDelay = 360
            duration = 720
        }

        surprisedIconAnimator.apply {
            addUpdateListener {
                splash_icon_surprised.translationY = animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
            repeatCount = ValueAnimator.INFINITE
            startDelay = 480
            duration = 720
        }
        animatorSet.start()
    }

    fun stopAnimation() {
        happyIconAnimator.end()
    }
}
