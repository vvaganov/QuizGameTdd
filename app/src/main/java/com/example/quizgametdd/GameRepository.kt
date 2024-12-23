package com.example.quizgametdd

import android.util.Log

interface GameRepository {

    fun questionAndChoices(): QuestionAndChoices

    fun saveUserChoice(index: Int)

    fun check(): CorrectAndUserChoiceIndex

    fun next()

    class Base(
        private val list: List<QuestionAndChoices> = listOf(
            QuestionAndChoices(
                question = "What color is the sky ",
                choices = listOf("blue", "green", "red", "yellow"),
                correctIndex = 0
            ),
            QuestionAndChoices(
                question = "What color is the sky grass ",
                choices = listOf("green", "blue", "red", "yellow"),
                correctIndex = 0
            ),
            QuestionAndChoices(
                question = "What color is the sun ",
                choices = listOf("green", "blue", "red", "yellow"),
                correctIndex = 3
            )
        )
    ) : GameRepository {

        private var index = 0

        override fun questionAndChoices(): QuestionAndChoices {
            return list[index]
        }

        private var userChoiceIndex = -1

        override fun saveUserChoice(index: Int) {
            userChoiceIndex = index
        }

        override fun check(): CorrectAndUserChoiceIndex {
            return CorrectAndUserChoiceIndex(
                correctIndex = questionAndChoices().correctIndex,
                userChoiceIndexed = userChoiceIndex
            )
        }

        override fun next() {
            userChoiceIndex - 1
            if (index==list.size - 1) index = 0 else index++
            Log.i("!!!", "indexNext = $index")
        }
    }
}
