package com.lyh.dailydialog.presenter.splash


import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.lyh.dailydialog.R
import com.lyh.dailydialog.presenter.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    private val splashAnimator = ValueAnimator.ofFloat(0f, 1f)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        splashAnimator.apply {
            addUpdateListener {
                splash_logo.scaleX = it.animatedValue as Float
                splash_logo.scaleY = it.animatedValue as Float
            }

            doOnEnd {
                lifecycleScope.launch {
                    delay(300)
                    findNavController().navigate(R.id.action_splashFragment_to_recordFragment)
                }
            }
            interpolator = AccelerateInterpolator()
            duration = 1000
            start()
        }
    }

    fun stopAnimation() {
        splashAnimator.end()
    }

}
