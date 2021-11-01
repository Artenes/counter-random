package io.github.artenes.counter

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.view.View

class TickAnimation(private val view: View): ValueAnimator.AnimatorUpdateListener {

    companion object {
        const val TICK_FORCE: Long = 30
    }

    private val startTranslation = view.translationY
    private val endTranslation = view.translationY - TICK_FORCE

    init {
        val goesUp = ValueAnimator.ofFloat(startTranslation, endTranslation)
        val goesDown = ValueAnimator.ofFloat(endTranslation, startTranslation)

        goesUp.duration = TICK_FORCE
        goesDown.duration = TICK_FORCE

        goesUp.addUpdateListener(this)
        goesDown.addUpdateListener(this)

        AnimatorSet().apply {
            play(goesUp).before(goesDown)
            start()
        }
    }

    override fun onAnimationUpdate(animation: ValueAnimator) {
        view.translationY = animation.animatedValue as Float
    }
}