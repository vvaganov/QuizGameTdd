package com.example.quizgametdd.view.stats

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.quizgametdd.R
import java.io.Serializable

class StatsTextView: AppCompatTextView, UpdateStats {

    private lateinit var state: StatsUiState

    constructor(context:Context) : super(context)
        constructor(context: Context, attr: AttributeSet): super(context, attr)
        constructor(context: Context, attr: AttributeSet, defStyleAttr:Int): super(context, attr,defStyleAttr)

    override fun onSaveInstanceState(): Parcelable? {
            return super.onSaveInstanceState()?.let {
                val saveState = StatsSavedState(it)
                saveState.save(state)
                return saveState
            }
        }

        override fun onRestoreInstanceState(state: Parcelable?) {
            val restoreState = state as StatsSavedState
            super.onRestoreInstanceState(restoreState.superState)
            update(restoreState.restore())
        }

    override fun update(uiStats: StatsUiState) {
        state = uiStats
        state.update(this)
    }


    override fun update(correct: Int, incorrect: Int) {
        text = resources.getString(R.string.stats, correct, incorrect)
    }
}

interface StatsUiState : Serializable{

    fun update(statsTextView: UpdateStats)

    class Base(private  val correct: Int, private val incorrect: Int) : StatsUiState{

        override fun update(statsTextView: UpdateStats) {
            statsTextView.update(correct, incorrect)
        }
    }

}


interface UpdateStats{

    fun update(uiStats: StatsUiState)

    fun update(correct:Int, incorrect:Int)
}