package com.example.quizgametdd.view.visibilityButton

import java.io.Serializable

data class VisibilityUiState (private val visibility:Int) :Serializable {

    fun update(updateVisibility: UpdateVisibilityButton) = updateVisibility.update(visibility)
}
