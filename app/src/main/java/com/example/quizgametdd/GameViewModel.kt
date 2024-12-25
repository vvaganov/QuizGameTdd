package com.example.quizgametdd

class GameViewModel(private val repository: GameRepository) {

    fun init(isOneRun: Boolean = true): GameUiState {
        if (isOneRun) {
            val data = repository.questionAndChoices()
            return GameUiState.AskQuestion(
                question = data.question,
                choices = data.choices
            )
        } else {
            return GameUiState.Empty
        }
    }

    fun chooseFirst(): GameUiState {
        repository.saveUserChoice(index = 0)
        val data = repository.questionAndChoices()
        return GameUiState.ChoiceMake(
            choices = data.choices.mapIndexed { index, string ->
                if (index == 0) {
                    ChoicesUiState.NotAvailableToChoose
                } else {
                    ChoicesUiState.AvailableToChoose
                }
            }
        )
    }

    fun chooseSecond(): GameUiState {
        repository.saveUserChoice(index = 1)
        val data = repository.questionAndChoices()
        return GameUiState.ChoiceMake(
            choices = data.choices.mapIndexed { index, string ->
                if (index == 1) {
                    ChoicesUiState.NotAvailableToChoose
                } else {
                    ChoicesUiState.AvailableToChoose
                }
            }
        )
    }

    fun chooseThree(): GameUiState {
        repository.saveUserChoice(index = 2)
        val data = repository.questionAndChoices()
        return GameUiState.ChoiceMake(
            choices = data.choices.mapIndexed { index, _ ->
                if (index == 2) {
                    ChoicesUiState.NotAvailableToChoose
                } else {
                    ChoicesUiState.AvailableToChoose
                }
            }
        )
    }

    fun chooseFour(): GameUiState {
        repository.saveUserChoice(index = 3)
        val data = repository.questionAndChoices()
        return GameUiState.ChoiceMake(
            choices = data.choices.mapIndexed { index, _ ->
                if (index == 3) {
                    ChoicesUiState.NotAvailableToChoose
                } else {
                    ChoicesUiState.AvailableToChoose
                }
            }
        )
    }

    fun chooseNext(): GameUiState {
        repository.next()
        return init()
    }

    fun chooseCheck(): GameUiState {
        val data = repository.questionAndChoices()
        val correctAndUserChoiceIndex = repository.check()
        return GameUiState.AnswerCheck(
            choices = data.choices.mapIndexed { index, _ ->
                if (correctAndUserChoiceIndex.correctIndex == index)
                    ChoicesUiState.Correct
                else if (correctAndUserChoiceIndex.userChoiceIndexed == index)
                    ChoicesUiState.InCorrect
                else
                    ChoicesUiState.NotAvailableToChoose

            }
        )
    }
}
