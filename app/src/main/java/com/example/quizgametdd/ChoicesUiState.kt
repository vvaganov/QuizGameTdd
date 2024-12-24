package com.example.quizgametdd

import android.graphics.Color
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import java.io.Serializable

interface ChoicesUiState : Serializable {

    fun update(button: AppCompatButton)

    abstract class Abstract(
        private val value: String,
        private val color: String,
        private val clickable: Boolean = false,
        private val enabled: Boolean = true

    ) : ChoicesUiState {
        override fun update(button: AppCompatButton) = with(button) {
            text = value
            if (enabled)
                setBackgroundColor(Color.parseColor(color))
            isClickable = clickable
            isEnabled = enabled
        }
    }

    data class NotAvailableToChoose(private val text: String) :
        Abstract(value = text, color = "", enabled = false)

    data class AvailableToChoose(private val text: String) :
        Abstract(value = text, color = "#60ABBC", clickable = true)

    data class Correct(private val text: String) :
        Abstract(value = text, color = "#1ADC22")

    data class InCorrect(private val text: String) :
        Abstract(value = text, color = "#FF0606")
}
