package io.github.artenes.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class RandomViewModel(val maxValue: Int) : ViewModel() {

    private val _random = MutableLiveData<Int>()
    val random: LiveData<Int>
        get() {
            return _random
        }

    init {
        _random.value = Random().nextInt(maxValue + 1)
    }

}