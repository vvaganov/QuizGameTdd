package com.example.quizgametdd

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class QuestionUi(
    text: String,
    containerIdViewMatcher: Matcher<View>,
    classTypeMatchers: Matcher<View>
) {

    private val interaction: ViewInteraction = onView(
        allOf(
            containerIdViewMatcher,
            classTypeMatchers,
            withId(R.id.questionTextView),
            withText(text),
            isAssignableFrom(TextView::class.java)
        )
    )
    fun assertTextVisible() {
        interaction.check(matches(isDisplayed()))
    }

}
