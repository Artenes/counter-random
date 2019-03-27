package io.github.artenes.counter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_random_number.*

class RandomNumberActivity : AppCompatActivity() {

    internal lateinit var viewModel: RandomViewModel

    private val onRandom = Observer<Int> {
        randomTextView.text = it.toString()
    }

    private fun updateTitle() {
        titleTextView.text = getString(R.string.here_is_a_random_number, viewModel.maxValue)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)

        val maxValue = intent.getIntExtra(EXTRA_MAX_VALUE, 0)
        val factory = RandomViewModelFactory(maxValue)
        viewModel = ViewModelProviders.of(this, factory).get(RandomViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        viewModel.random.observe(this, onRandom)
        updateTitle()
    }

    companion object {

        const val EXTRA_MAX_VALUE = "EXTRA_MAX_VALUE"

        fun start(context: Context, maxValue: Int) {
            val intent = Intent(context, RandomNumberActivity::class.java)
            intent.putExtra(EXTRA_MAX_VALUE, maxValue)
            context.startActivity(intent)
        }

    }

}
