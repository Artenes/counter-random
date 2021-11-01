package io.github.artenes.counter

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CounterViewModel

    private val onCounterChange = Observer<Int> { count ->
        counterTextView.text = count.toString()
        TickAnimation(counterTextView)
    }

    private val onVibrate = Observer<Long> { duration ->

        getSystemService(Vibrator::class.java).vibrate(duration)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        viewModel.counter.observe(this, onCounterChange)
        viewModel.vibrationDuration.observe(this, onVibrate)
    }

    fun onCountClick(view: View) {
        viewModel.count()
    }

    fun onClearClick(view: View) {
        viewModel.reset()
    }

    fun onRandomClick(view: View) {
        RandomNumberActivity.start(this, viewModel.counter.value as Int)
    }

}
