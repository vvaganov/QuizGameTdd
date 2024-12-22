package com.example.quizgametdd

import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.isNotClickable
import androidx.test.espresso.matcher.ViewMatchers.isNotEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.hamcrest.core.IsNot.not

class ChoiceUiState(
    id:Int,
    text: String,
    containerIdViewMatcher: Matcher<View>,
    classTypeMatchers: Matcher<View>
): AbstractButton(
    onView(
        allOf(
            containerIdViewMatcher,
            classTypeMatchers,
            withText(text),
            withId(id),
            isAssignableFrom(AppCompatButton::class.java),
            isDisplayed()
        )
    )
) {
    fun assertAvailableToChooseState() {
       interaction.check(matches(ButtonColorMatcher("#60ABBC")))
           .check(matches(isEnabled()))
           .check(matches(isClickable()))
    }

    fun assertNotAvailableToChooseState() {
        interaction.check(matches(isNotEnabled()))
    }

    fun assertCorrectState() {
        interaction.check(matches(ButtonColorMatcher("#1ADC22")))
            .check(matches(isEnabled()))
            .check(matches(isNotClickable()))
    }

    fun assertNotCorrectState() {
        interaction.check(matches(ButtonColorMatcher("#FF0606")))
            .check(matches(isNotClickable()))
    }

}
