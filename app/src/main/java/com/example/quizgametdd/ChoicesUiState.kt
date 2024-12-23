package com.example.quizgametdd

interface ChoicesUiState {

   data class NotAvailableToChoose(val text: String) : ChoicesUiState

   data class AvailableToChoose(val text: String): ChoicesUiState

   data class Correct(val text: String): ChoicesUiState

   data class InCorrect(val text: String): ChoicesUiState

}
