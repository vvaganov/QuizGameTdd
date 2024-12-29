package com.example.quizgametdd

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class StatsUi(
    correct: Int,
    incorrect: Int,
    containerIdViewMatcher: Matcher<View>,
    classTypeMatchers: Matcher<View>
) {
    private val interaction: ViewInteraction =
        onView(
            allOf(
                withId(R.id.statsTextView),
                containerIdViewMatcher,
                classTypeMatchers,
                isAssignableFrom(TextView::class.java),
                withText("Game Over\n\nCorrects: $correct\nIncorrects: $incorrect")
            )
        )

    fun assertVisible(){
        interaction.check(matches(isDisplayed()))
    }

    fun diesNotExist() {
        interaction.check(doesNotExist())
    }
}
