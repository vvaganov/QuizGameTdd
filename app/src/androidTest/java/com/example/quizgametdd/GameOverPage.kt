package com.example.quizgametdd

import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher

class GameOverPage(correct: Int, incorrect: Int) {

    private val containerIdViewMatcher: Matcher<View> = withParent(withId(R.id.gameOverContainer))
    private val classTypeMatchers: Matcher<View> =
        withParent(isAssignableFrom(FrameLayout::class.java))

    private val statsUi: StatsUi = StatsUi(
        correct = correct,
        incorrect = incorrect,
        containerIdViewMatcher = containerIdViewMatcher,
        classTypeMatchers = classTypeMatchers
    )

    private val buttonNewGameUi = ButtonUi(
        id = R.id.newGameButton,
        textResId = R.string.newGame,
        color = "#0055B8",
        containerIdViewMatcher = containerIdViewMatcher,
        classTypeMatchers = classTypeMatchers
    )

    fun assertInitialGameOverState() {
        statsUi.assertVisible()
    }

    fun clickNewGame() {
        buttonNewGameUi.click()
    }

    fun assertNotVisible() {
        statsUi.diesNotExist()
    }

}
