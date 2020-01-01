package com.lyh.dailydialog.presenter.custom

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.AccelerateInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import com.lyh.dailydialog.R
import kotlinx.android.synthetic.main.custom_anim_emoticon.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CustomAnimEmoticon(
    context: Context?,
    attrs: AttributeSet?
) : ConstraintLayout(context, attrs) {

    private val happyIconAnimator = ValueAnimator.ofFloat(0f, -60f, 0f)
    private val angryIconAnimator = ValueAnimator.ofFloat(0f, -60f, 0f)
    private val loveIconAnimator = ValueAnimator.ofFloat(0f, -60f, 0f)
    private val sadIconAnimator = ValueAnimator.ofFloat(0f, -60f, 0f)
    private val surprisedIconAnimator = ValueAnimator.ofFloat(0f, -60f, 0f)
    val endIconAnimator = ValueAnimator.ofFloat(1f, 0f)
    val animatorSet = AnimatorSet().apply {
        play(happyIconAnimator)
            .with(angryIconAnimator)
            .with(loveIconAnimator)
            .with(sadIconAnimator)
            .with(surprisedIconAnimator)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_anim_emoticon, this)
        happyIconAnimator.apply {
            addUpdateListener {
                splash_icon_happy.translationY = animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
            duration = 720
        }

        angryIconAnimator.apply {
            addUpdateListener {
                splash_icon_angry.translationY = animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
            startDelay = 120
            duration = 720
        }

        loveIconAnimator.apply {
            addUpdateListener {
                splash_icon_love.translationY = animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
            startDelay = 240
            duration = 720
        }

        sadIconAnimator.apply {
            addUpdateListener {
                splash_icon_sad.translationY = animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
            startDelay = 360
            duration = 720
        }

        surprisedIconAnimator.apply {
            addUpdateListener {
                splash_icon_surprised.translationY = animatedValue as Float
            }
            interpolator = AccelerateInterpolator()
            startDelay = 480
            duration = 720
        }

        endIconAnimator.apply {
            addUpdateListener {
                (it.animatedValue as Float).let { animAlpha ->
                    splash_icon_happy.alpha = animAlpha
                    splash_icon_angry.alpha = animAlpha
                    splash_icon_love.alpha = animAlpha
                    splash_icon_sad.alpha = animAlpha
                    splash_icon_surprised.alpha = animAlpha
                }
            }
            interpolator = AccelerateInterpolator()
        }

        animatorSet.doOnEnd {
            GlobalScope.launch(Dispatchers.Main) {
                delay(300)
                animatorSet.start()
            }
        }
    }
}
