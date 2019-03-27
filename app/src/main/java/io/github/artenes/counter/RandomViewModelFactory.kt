package io.github.artenes.counter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RandomViewModelFactory(val maxValue: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RandomViewModel(maxValue) as T
    }

}