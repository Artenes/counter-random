package io.github.artenes.counter

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RandomNumberActivityTest {

    @Rule
    @JvmField
    var randomActivityRule = ActivityTestRule<RandomNumberActivity>(RandomNumberActivity::class.java, true, false)

    @Test
    fun start_showZeroWhenNoMaxValueIsProvided() {

        //given I did not pass any value to the activity

        //when I open it
        randomActivityRule.launchActivity(null)

        //then it should display 0 on title and on the random value
        onView(withId(R.id.titleTextView)).check(matches(withSubstring("0")))
        onView(withId(R.id.randomTextView)).check(matches(withText("0")))

    }

    @Test
    fun start_showRandomValue() {

        //given I pass a max value to the activity
        val intent = Intent().apply { putExtra(RandomNumberActivity.EXTRA_MAX_VALUE, 10) }

        //when I start the activity
        randomActivityRule.launchActivity(intent)

        //then it should display a random value
        val randomNumber = randomActivityRule.activity.viewModel.random.value.toString()
        onView(withId(R.id.randomTextView)).check(matches(withText(randomNumber)))

    }

    @Test
    fun start_showMaxValue() {

        //given I pass a max value to the activity
        val intent = Intent().apply { putExtra(RandomNumberActivity.EXTRA_MAX_VALUE, 10) }

        //when I start the activity
        randomActivityRule.launchActivity(intent)

        //then it should display the max value
        onView(withId(R.id.titleTextView)).check(matches(withSubstring("10")))

    }

}