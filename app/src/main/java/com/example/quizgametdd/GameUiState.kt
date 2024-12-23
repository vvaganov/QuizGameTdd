package com.example.quizgametdd

import android.util.Log
import android.view.View
import com.example.quizgametdd.databinding.ActivityMainBinding

interface GameUiState {

    fun update(binding: ActivityMainBinding) {

    }

    abstract class Abstract(
        private val question: String,
        private val choicesListUiState: List<ChoicesUiState>,
        private val checkVisibility: Int,
        private val nextVisibility: Int
    ) : GameUiState {
        override fun update(binding: ActivityMainBinding) = with(binding) {
            questionTextView.text = question
            choicesListUiState[0].update(firstChoiceButton)
            choicesListUiState[1].update(secondChoiceButton)
            choicesListUiState[2].update(threeChoiceButton)
            choicesListUiState[3].update(fourChoiceButton)
            checkButton.visibility = checkVisibility
            nextButton.visibility = nextVisibility
        }
    }

    data class AskQuestion(
        val question: String,
        val choices: List<String>
    ) : Abstract(
        question = question,
        choicesListUiState = choices.map { ChoicesUiState.AvailableToChoose(text = it) },
        checkVisibility = View.GONE,
        nextVisibility = View.GONE
    )

    data class ChoiceMake(
        val question: String,
        val choices: List<ChoicesUiState>
    ) : Abstract(
        question = question,
        choicesListUiState = choices,
        checkVisibility = View.VISIBLE,
        nextVisibility = View.GONE
    )

    data class AnswerCheck(
        val question: String,
        val choices: List<ChoicesUiState>
    ) : Abstract(
        question = question,
        choicesListUiState = choices,
        checkVisibility = View.GONE,
        nextVisibility = View.VISIBLE
    )
}





