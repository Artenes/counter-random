package io.github.artenes.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    companion object {
        const val SHORT_VIBRATION = 100L
        const val LONG_VIBRATION = 700L
    }

    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() {
            return _counter
        }

    private val _vibrationDuration = MutableLiveData<Long>()
    val vibrationDuration: LiveData<Long>
        get() {
            return _vibrationDuration
        }

    init {
        _counter.value = 0
    }

    fun count() {
        _counter.value = _counter.value?.plus(1)
        _vibrationDuration.value = SHORT_VIBRATION
    }

    fun reset() {
        _counter.value = 0
        _vibrationDuration.value = LONG_VIBRATION
    }

}