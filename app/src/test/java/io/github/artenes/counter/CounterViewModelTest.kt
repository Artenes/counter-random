package io.github.artenes.counter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CounterViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: CounterViewModel

    @Before
    fun setUp() {
        viewModel = CounterViewModel()
    }

    @Test
    fun count_isIncrementing() {

        //given I have an empty counter
        //initial value is 0

        //when I call the count method
        viewModel.count()

        //then it should increment its internal counter
        assertEquals(1, viewModel.counter.value)

    }

    @Test
    fun reset_isClearing() {

        //given I have a counter with value greater than zero
        viewModel.count()
        viewModel.count()
        viewModel.count()

        //when i reset its value
        viewModel.reset()

        //then its value should be 0
        assertEquals(0, viewModel.counter.value)

    }

    @Test
    fun count_isVibrating() {

        //given I have a view model

        //when I increment the counter
        viewModel.count()

        //then it should do a short vibration
        assertEquals(CounterViewModel.SHORT_VIBRATION, viewModel.vibrationDuration.value)

    }

    @Test
    fun reset_isVibrating() {

        //given I have a view model

        //when I reset its counter
        viewModel.reset()

        //then it should do a long vibration
        assertEquals(CounterViewModel.LONG_VIBRATION, viewModel.vibrationDuration.value)

    }

}