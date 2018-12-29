package io.github.artenes.counter

import android.content.res.Configuration
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        updateCouterTextView()
    }

    fun updateCouterTextView() {
        counterTextView.text = counter.toString()
    }

    fun vibrate(time: Long) {
        getSystemService(Vibrator::class.java).vibrate(time)
    }

    fun onCountClick(view: View) {
        counter++
        updateCouterTextView()
        vibrate(100L)
    }

    fun onClearClick(view: View) {
        counter = 0
        updateCouterTextView()
        vibrate(700L)
    }

    fun onRandomClick(view: View) {
        RandomNumberActivity.start(this, counter)
    }

}
