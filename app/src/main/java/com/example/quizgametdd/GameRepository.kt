package com.example.quizgametdd

interface GameRepository {

    fun questionAndChoices(): QuestionAndChoices

    fun saveUserChoice(index: Int)

    fun check(): CorrectAndUserChoiceIndex

    fun next()

    class Base(
        private val index: IntCash,
        private val userChoiceIndex: IntCash,
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


        override fun questionAndChoices(): QuestionAndChoices {
            return list[index.read()]
        }

        override fun saveUserChoice(index: Int) {
            userChoiceIndex.save(index)
        }

        override fun check(): CorrectAndUserChoiceIndex {
            return CorrectAndUserChoiceIndex(
                correctIndex = questionAndChoices().correctIndex,
                userChoiceIndexed = userChoiceIndex.read()
            )
        }

        override fun next() {
            userChoiceIndex.save(-1)
            if (index.read() == list.size - 1) index.save(0) else index.save(index.read() + 1)
        }
    }
}

