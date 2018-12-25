package io.github.artenes.counter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_random_number.*
import java.util.*

class RandomNumberActivity : AppCompatActivity() {

    val maxValue: Int by lazy {
        intent.getIntExtra(EXTRA_MAX_VALUE, 0)
    }

    val randomNumber: Int by lazy {
        Random().nextInt(maxValue + 1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)
    }

    override fun onResume() {
        super.onResume()
        updateTitle()
        updateRandomNumber()
    }

    fun updateTitle() {
        titleTextView.text = getString(R.string.here_is_a_random_number, maxValue)
    }

    fun updateRandomNumber() {
        randomTextView.text = randomNumber.toString()
    }

    companion object {

        private const val EXTRA_MAX_VALUE = "EXTRA_MAX_VALUE"

        fun start(context: Context, maxValue: Int) {
            val intent = Intent(context, RandomNumberActivity::class.java)
            intent.putExtra(EXTRA_MAX_VALUE, maxValue)
            context.startActivity(intent)
        }

    }

}
