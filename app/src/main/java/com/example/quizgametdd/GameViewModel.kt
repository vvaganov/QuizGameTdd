package com.example.quizgametdd

class GameViewModel(private val repository: GameRepository) {

    fun init(): GameUiState {
        val data = repository.questionAndChoices()
        return GameUiState.AskQuestion(
            question = data.question,
            choices = data.choices
        )
    }

    fun chooseFirst(): GameUiState {
        repository.saveUserChoice(index = 0)
        val data = repository.questionAndChoices()
        return GameUiState.ChoiceMake(
            question = data.question,
            choices = data.choices.mapIndexed { index, string ->
                if (index == 0) {
                    ChoicesUiState.NotAvailableToChoose(text = string)
                } else {
                    ChoicesUiState.AvailableToChoose(text = string)
                }
            }
        )
    }

    fun chooseSecond(): GameUiState {
        repository.saveUserChoice(index = 1)
        val data = repository.questionAndChoices()
        return GameUiState.ChoiceMake(
            question = data.question,
            choices = data.choices.mapIndexed { index, string ->
                if (index == 1) {
                    ChoicesUiState.NotAvailableToChoose(text = string)
                } else {
                    ChoicesUiState.AvailableToChoose(text = string)
                }
            }
        )
    }

    fun chooseThree(): GameUiState {
        repository.saveUserChoice(index = 2)
        val data = repository.questionAndChoices()
        return GameUiState.ChoiceMake(
            question = data.question,
            choices = data.choices.mapIndexed { index, string ->
                if (index == 2) {
                    ChoicesUiState.NotAvailableToChoose(text = string)
                } else {
                    ChoicesUiState.AvailableToChoose(text = string)
                }
            }
        )
    }

    fun chooseFour(): GameUiState {
        repository.saveUserChoice(index = 3)
        val data = repository.questionAndChoices()
        return GameUiState.ChoiceMake(
            question = data.question,
            choices = data.choices.mapIndexed { index, string ->
                if (index == 3) {
                    ChoicesUiState.NotAvailableToChoose(text = string)
                } else {
                    ChoicesUiState.AvailableToChoose(text = string)
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
            question = data.question,
            choices = data.choices.mapIndexed { index, string ->
                if (correctAndUserChoiceIndex.correctIndex == index)
                    ChoicesUiState.Correct(text = string)
                else if (correctAndUserChoiceIndex.userChoiceIndexed == index)
                    ChoicesUiState.InCorrect(text = string)
                else
                    ChoicesUiState.NotAvailableToChoose(text = string)

            }
        )
    }
}
