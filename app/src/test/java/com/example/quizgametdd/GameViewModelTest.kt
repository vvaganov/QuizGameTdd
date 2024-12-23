package com.example.quizgametdd

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class GameViewModelTest {


    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        viewModel = GameViewModel(repository = FakeRepository())
    }

    @Test
    fun caseNumber1() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.AskQuestion(
            question = "q1",
            choices = listOf("c1", "c2", "c3", "c4")
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseFirst()
        expected = GameUiState.ChoiceMake(
            question = "q1",
            choices = listOf(
                ChoicesUiState.NotAvailableToChoose(text = "c1"),
                ChoicesUiState.AvailableToChoose(text = "c2"),
                ChoicesUiState.AvailableToChoose(text = "c3"),
                ChoicesUiState.AvailableToChoose(text = "c4"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseCheck()
        expected = GameUiState.AnswerCheck(
            question = "q1",
            choices = listOf(
                ChoicesUiState.Correct(text = "c1"),
                ChoicesUiState.NotAvailableToChoose(text = "c2"),
                ChoicesUiState.NotAvailableToChoose(text = "c3"),
                ChoicesUiState.NotAvailableToChoose(text = "c4"),

                )
        )
        assertEquals(expected, actual)
    }

    @Test
    fun caseNumber2() {

        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.AskQuestion(
            question = "q1",
            choices = listOf("c1", "c2", "c3", "c4")
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseFirst()
        expected = GameUiState.ChoiceMake(
            question = "q1",
            choices = listOf(
                ChoicesUiState.NotAvailableToChoose(text = "c1"),
                ChoicesUiState.AvailableToChoose(text = "c2"),
                ChoicesUiState.AvailableToChoose(text = "c3"),
                ChoicesUiState.AvailableToChoose(text = "c4"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseSecond()
        expected = GameUiState.ChoiceMake(
            question = "q1",
            choices = listOf(
                ChoicesUiState.AvailableToChoose(text = "c1"),
                ChoicesUiState.NotAvailableToChoose(text = "c2"),
                ChoicesUiState.AvailableToChoose(text = "c3"),
                ChoicesUiState.AvailableToChoose(text = "c4"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseThree()
        expected = GameUiState.ChoiceMake(
            question = "q1",
            choices = listOf(
                ChoicesUiState.AvailableToChoose(text = "c1"),
                ChoicesUiState.AvailableToChoose(text = "c2"),
                ChoicesUiState.NotAvailableToChoose(text = "c3"),
                ChoicesUiState.AvailableToChoose(text = "c4"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseFour()
        expected = GameUiState.ChoiceMake(
            question = "q1",
            choices = listOf(
                ChoicesUiState.AvailableToChoose(text = "c1"),
                ChoicesUiState.AvailableToChoose(text = "c2"),
                ChoicesUiState.AvailableToChoose(text = "c3"),
                ChoicesUiState.NotAvailableToChoose(text = "c4"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseCheck()
        expected = GameUiState.AnswerCheck(
            question = "q1",
            choices = listOf(
                ChoicesUiState.Correct(text = "c1"),
                ChoicesUiState.NotAvailableToChoose(text = "c2"),
                ChoicesUiState.NotAvailableToChoose(text = "c3"),
                ChoicesUiState.InCorrect(text = "c4"),
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseNext()
        expected = GameUiState.AskQuestion(
            question = "q2",
            choices = listOf("d1", "d2", "d3", "d4")
        )
        assertEquals(expected, actual)
    }
}

private class FakeRepository : GameRepository {

    private val list: List<QuestionAndChoices> = listOf(
        QuestionAndChoices(
            question = "q1",
            choices = listOf("c1", "c2", "c3", "c4"),
            correctIndex = 0
        ),
        QuestionAndChoices(
            question = "q2",
            choices = listOf("d1", "d2", "d3", "d4"),
            correctIndex = 0
        ),
    )

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
        index++
        if (index == list.size) index = 0

    }

}

