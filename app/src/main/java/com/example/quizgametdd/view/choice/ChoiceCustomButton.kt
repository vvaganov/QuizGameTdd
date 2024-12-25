package com.example.quizgametdd.view.choice

import android.content.Context
import android.graphics.Color
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.example.quizgametdd.ChoicesUiState
import com.example.quizgametdd.view.question.UpdateText

class ChoiceCustomButton : AppCompatButton, UpdateChoiceButton {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)
    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        context,
        attr,
        defStyleAttr
    )

    override fun getFreezesText(): Boolean = true

    private lateinit var state: ChoicesUiState

    override fun update(state: ChoicesUiState) {
        this.state = state
        state.update(this)
    }

    override fun update(color: String, clickable: Boolean, enabled: Boolean) {
        isClickable = clickable
        isEnabled = enabled
        setBackgroundColor(Color.parseColor(color))
    }

    override fun update(text: String) {
        this.text = text
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val saveState = ChoiceButtonSavedState(it)
            saveState.save(state)
            return saveState
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoreState = state as ChoiceButtonSavedState
        super.onRestoreInstanceState(restoreState.superState)
        update(restoreState.restore())
    }
}

interface UpdateChoiceButton : UpdateText {
    fun update(state: ChoicesUiState)

    fun update(
        color: String,
        clickable: Boolean,
        enabled: Boolean
    )
}