package io.github.artenes.counter

import android.os.Bundle
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

    fun onCountClick(view: View) {
        counter++
        updateCouterTextView()
    }

    fun onClearClick(view: View) {
        counter = 0
        updateCouterTextView()
    }

    fun onRandomClick(view: View) {
        RandomNumberActivity.start(this, counter)
    }

}
