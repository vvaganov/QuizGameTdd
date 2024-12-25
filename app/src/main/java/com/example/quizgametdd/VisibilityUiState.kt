package com.example.quizgametdd

import com.example.quizgametdd.view.visibilityButton.UpdateVisibilityButton
import java.io.Serializable

data class VisibilityUiState (private val visibility:Int) :Serializable {

    fun update(updateVisibility: UpdateVisibilityButton) = updateVisibility.update(visibility)
}
