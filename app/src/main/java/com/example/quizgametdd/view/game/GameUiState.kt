package com.example.quizgametdd.view.game

import android.view.View
import com.example.quizgametdd.view.choice.ChoicesUiState
import com.example.quizgametdd.view.visibilityButton.VisibilityUiState
import com.example.quizgametdd.view.question.UpdateText
import com.example.quizgametdd.view.choice.UpdateChoiceButton
import com.example.quizgametdd.view.visibilityButton.UpdateVisibilityButton
import java.io.Serializable

interface GameUiState : Serializable {

    fun update(
        questionCustomTextView: UpdateText,
        firstChoiceButton: UpdateChoiceButton,
        secondChoiceButton: UpdateChoiceButton,
        thirdChoiceButton: UpdateChoiceButton,
        fourChoiceButton: UpdateChoiceButton,
        nextButton: UpdateVisibilityButton,
        checkButton: UpdateVisibilityButton
    )

    object Empty : GameUiState {
        override fun update(
            questionCustomTextView: UpdateText,
            firstChoiceButton: UpdateChoiceButton,
            secondChoiceButton: UpdateChoiceButton,
            thirdChoiceButton: UpdateChoiceButton,
            fourChoiceButton: UpdateChoiceButton,
            nextButton: UpdateVisibilityButton,
            checkButton: UpdateVisibilityButton
        ) = Unit
    }

    data class AskQuestion(
        val question: String,
        val choices: List<String>
    ) : GameUiState {
        override fun update(
            questionCustomTextView: UpdateText,
            firstChoiceButton: UpdateChoiceButton,
            secondChoiceButton: UpdateChoiceButton,
            thirdChoiceButton: UpdateChoiceButton,
            fourChoiceButton: UpdateChoiceButton,
            nextButton: UpdateVisibilityButton,
            checkButton: UpdateVisibilityButton
        ) {
            questionCustomTextView.update(question)
            firstChoiceButton.update(ChoicesUiState.Initial(choices[0]))
            secondChoiceButton.update(ChoicesUiState.Initial(choices[1]))
            thirdChoiceButton.update(ChoicesUiState.Initial(choices[2]))
            fourChoiceButton.update(ChoicesUiState.Initial(choices[3]))
            nextButton.update(VisibilityUiState(View.GONE))
            checkButton.update(VisibilityUiState(View.GONE))
        }
    }

    data class ChoiceMake(
        val choices: List<ChoicesUiState>
    ) : GameUiState {
        override fun update(
            questionCustomTextView: UpdateText,
            firstChoiceButton: UpdateChoiceButton,
            secondChoiceButton: UpdateChoiceButton,
            thirdChoiceButton: UpdateChoiceButton,
            fourChoiceButton: UpdateChoiceButton,
            nextButton: UpdateVisibilityButton,
            checkButton: UpdateVisibilityButton
        ) {
            firstChoiceButton.update(choices[0])
            secondChoiceButton.update(choices[1])
            thirdChoiceButton.update(choices[2])
            fourChoiceButton.update(choices[3])
            checkButton.update(VisibilityUiState(View.VISIBLE))
        }
    }

    data class AnswerCheck(
        val choices: List<ChoicesUiState>
    ) : GameUiState {
        override fun update(
            questionCustomTextView: UpdateText,
            firstChoiceButton: UpdateChoiceButton,
            secondChoiceButton: UpdateChoiceButton,
            thirdChoiceButton: UpdateChoiceButton,
            fourChoiceButton: UpdateChoiceButton,
            nextButton: UpdateVisibilityButton,
            checkButton: UpdateVisibilityButton
        ) {
            firstChoiceButton.update(choices[0])
            secondChoiceButton.update(choices[1])
            thirdChoiceButton.update(choices[2])
            fourChoiceButton.update(choices[3])
            checkButton.update(VisibilityUiState(View.GONE))
            nextButton.update(VisibilityUiState(View.VISIBLE))
        }
    }
}






