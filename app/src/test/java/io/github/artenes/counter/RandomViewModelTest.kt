package io.github.artenes.counter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class RandomViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun random_isBetweenZeroAndMaxValue() {

        //given I have 5 as max value
        val viewModel = RandomViewModel(5)

        //when I access the random generated value
        val random = viewModel.random.value as Int

        //then it should be between 0 and 5 (inclusive)
        assertTrue(random in 0..5)

    }

}