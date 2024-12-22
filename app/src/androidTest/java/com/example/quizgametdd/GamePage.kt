package com.example.quizgametdd

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher

class
GamePage(
    question: String,
    choices: List<String>
) {

    private val containerIdViewMatcher: Matcher<View> = withParent(withId(R.id.rootLayout))
    private val classTypeMatchers: Matcher<View> =
        withParent(isAssignableFrom(LinearLayout::class.java))

    private val questionUi = QuestionUi(
        text = question,
        containerIdViewMatcher = containerIdViewMatcher,
        classTypeMatchers = classTypeMatchers
    )

    private val listChoicesId = listOf(
        R.id.firstChoiceButton,
        R.id.secondChoiceButton,
        R.id.threeChoiceButton,
        R.id.fourChoiceButton,
    )
    private val choicesListUi = choices.mapIndexed { index, text ->
        ChoiceUiState(
            id = listChoicesId[index],
            text = text,
            containerIdViewMatcher = containerIdViewMatcher,
            classTypeMatchers = classTypeMatchers
        )
    }

    private val checkButtonUi = ButtonUi(
        id = R.id.checkButton,
        textResId = R.string.check,
        color = "#F2BD00",
        containerIdViewMatcher = containerIdViewMatcher,
        classTypeMatchers = classTypeMatchers
    )

    private val nextButtonUI = ButtonUi(
        id = R.id.nextButton,
        textResId = R.string.next,
        color = "#0478FF",
        containerIdViewMatcher = containerIdViewMatcher,
        classTypeMatchers = classTypeMatchers
    )

    fun assertAskQuestionState() {
        questionUi.assertTextVisible()
        choicesListUi.forEach {
            it.assertAvailableToChooseState()
        }
        checkButtonUi.assertNotVisible()
        nextButtonUI.assertNotVisible()
    }

    fun clickFirstChoice() {
        choicesListUi.first().click()
    }

    fun assertFirstChoiceMakeState() {
        questionUi.assertTextVisible()
        choicesListUi.first().assertNotAvailableToChooseState()
      for (i in 1 until choicesListUi.size ){
          choicesListUi[i].assertAvailableToChooseState()
      }
        checkButtonUi.assertVisible()
        nextButtonUI.assertNotVisible()
    }

    fun clickCheck() {
        checkButtonUi.click()
    }

    fun assertAnswerChoiceStateFirstCorrect() {
        questionUi.assertTextVisible()
        choicesListUi.first().assertCorrectState()
        for (i in 1 until choicesListUi.size ){
            choicesListUi[i].assertNotAvailableToChooseState()
        }
        checkButtonUi.assertNotVisible()
        nextButtonUI.assertVisible()
    }

    fun clickSecondChoice() {
        choicesListUi[1].click()
    }

    fun assertSecondChoiceMakeState() {
        questionUi.assertTextVisible()
        choicesListUi.forEachIndexed { index, choice ->
            if (index == 1){
                choice.assertNotAvailableToChooseState()
            }else{
                choice.assertAvailableToChooseState()
            }
        }
        checkButtonUi.assertVisible()
        nextButtonUI.assertNotVisible()
    }

    fun assertAnswerChoiceStateFirstCorrectSecondInCorrect() {
        questionUi.assertTextVisible()
        choicesListUi.first().assertCorrectState()
        choicesListUi[1].assertNotCorrectState()
        choicesListUi[2].assertNotAvailableToChooseState()
        choicesListUi[3].assertNotAvailableToChooseState()
        checkButtonUi.assertNotVisible()
        nextButtonUI.assertVisible()
    }

    fun clickNext() {
        nextButtonUI.click()
    }


}
