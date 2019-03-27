package io.github.artenes.counter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Rule
    @JvmField
    var mainActivityTestRule = IntentsTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun count_increaseCounter() {

        //given I have the activity open with a zero counter

        //when I press the count button
        onView(withId(R.id.countButton)).perform(click())

        //then it should display 1
        onView(withId(R.id.counterTextView)).check(matches(withText("1")))

    }

    @Test
    fun reset_clearCounter() {

        //give I pressed the count button more than once
        onView(withId(R.id.countButton)).perform(click())
        onView(withId(R.id.countButton)).perform(click())
        onView(withId(R.id.countButton)).perform(click())

        //when I press the reset button
        onView(withId(R.id.clearButton)).perform(click())

        //then the counter should be 0
        onView(withId(R.id.counterTextView)).check(matches(withText("0")))

    }

    @Test
    fun start_initiatesWithZero() {

        //given my activity is closed

        //when I open it

        //then I should see zero in the counter
        onView(withId(R.id.counterTextView)).check(matches(withText("0")))

    }

    @Test
    fun random_startsRandomActivity() {

        //given I pressed the count button 3 times
        onView(withId(R.id.countButton)).perform(click())
        onView(withId(R.id.countButton)).perform(click())
        onView(withId(R.id.countButton)).perform(click())

        //when I press the random button
        onView(withId(R.id.randomButton)).perform(click())

        //then it should start a new activity with the value of the counter
        intended(hasExtra(RandomNumberActivity.EXTRA_MAX_VALUE, 3))

    }

}