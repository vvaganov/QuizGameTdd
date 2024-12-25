package com.example.quizgametdd

import com.example.quizgametdd.view.choice.UpdateChoiceButton
import java.io.Serializable

interface ChoicesUiState : Serializable {

    fun update(update: UpdateChoiceButton)

    abstract class Abstract(
        private val color: String,
        private val clickable: Boolean = false,
        private val enabled: Boolean = true

    ) : ChoicesUiState {

        override fun update(update: UpdateChoiceButton) {
            update.update(color, clickable, enabled)
        }
    }

    data class Initial(private val text: String) :
        Abstract(color = "#60ABBC", clickable = true) {
        override fun update(update: UpdateChoiceButton) {
            super.update(update)
            update.update(text)
        }
    }

    object AvailableToChoose: Abstract(color = "#60ABBC", clickable = true)

    object NotAvailableToChoose: Abstract(color = "#C0C0C0", enabled = false)

    object Correct: Abstract(color = "#1ADC22")

    object InCorrect: Abstract(color = "#FF0606")
}
