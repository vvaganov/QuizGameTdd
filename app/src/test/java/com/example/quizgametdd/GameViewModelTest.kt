package com.example.quizgametdd

import com.example.quizgametdd.view.choice.ChoicesUiState
import com.example.quizgametdd.view.choice.CorrectAndUserChoiceIndex
import com.example.quizgametdd.view.game.GameRepository
import com.example.quizgametdd.view.game.GameUiState
import com.example.quizgametdd.view.game.GameViewModel
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

            choices = listOf(
                ChoicesUiState.NotAvailableToChoose,
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.AvailableToChoose,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseCheck()
        expected = GameUiState.AnswerCheck(
            choices = listOf(
                ChoicesUiState.Correct,
                ChoicesUiState.NotAvailableToChoose,
                ChoicesUiState.NotAvailableToChoose,
                ChoicesUiState.NotAvailableToChoose,

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
            choices = listOf(
                ChoicesUiState.NotAvailableToChoose,
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.AvailableToChoose,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseSecond()
        expected = GameUiState.ChoiceMake(
            choices = listOf(
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.NotAvailableToChoose,
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.AvailableToChoose,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseThree()
        expected = GameUiState.ChoiceMake(
            choices = listOf(
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.NotAvailableToChoose,
                ChoicesUiState.AvailableToChoose,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseFour()
        expected = GameUiState.ChoiceMake(
            choices = listOf(
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.AvailableToChoose,
                ChoicesUiState.NotAvailableToChoose,
            )
        )
        assertEquals(expected, actual)

        actual = viewModel.chooseCheck()
        expected = GameUiState.AnswerCheck(
            choices = listOf(
                ChoicesUiState.Correct,
                ChoicesUiState.NotAvailableToChoose,
                ChoicesUiState.NotAvailableToChoose,
                ChoicesUiState.InCorrect,
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

