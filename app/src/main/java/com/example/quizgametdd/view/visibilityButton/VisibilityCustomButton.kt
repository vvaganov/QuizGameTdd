package com.example.quizgametdd.view.visibilityButton

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.example.quizgametdd.VisibilityUiState

class VisibilityCustomButton : AppCompatButton, UpdateVisibilityButton {

    private lateinit var state: VisibilityUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)
    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        context,
        attr,
        defStyleAttr
    )


    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val saveState = VisibilitySavedState(it)
            saveState.save(state)
            return saveState
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoreState = state as VisibilitySavedState
        super.onRestoreInstanceState(restoreState.superState)
        update(restoreState.restore())
    }

    override fun update(visibility: Int) {
       this.visibility = visibility
    }

    override fun update(state: VisibilityUiState) {
        this.state = state
        state.update(this)
    }
}

interface UpdateVisibilityButton {
    fun update(visibility: Int)

    fun update(state: VisibilityUiState)
}