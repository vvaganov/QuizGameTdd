package com.example.quizgametdd.view.choice

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.os.Build

class ChoiceButtonSavedState : View.BaseSavedState {

    private lateinit var state: ChoicesUiState

    constructor(superState: Parcelable) : super(superState)

      private constructor(parcelIn: Parcel) : super(parcelIn) {
       state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             parcelIn.readSerializable(ChoicesUiState::class.java.classLoader, ChoicesUiState::class.java) as ChoicesUiState
        } else {
           parcelIn.readSerializable() as ChoicesUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): ChoicesUiState = state

    fun save(uiState: ChoicesUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ChoiceButtonSavedState> {
        override fun createFromParcel(parcel: Parcel): ChoiceButtonSavedState =
            ChoiceButtonSavedState(parcel)

        override fun newArray(size: Int): Array<ChoiceButtonSavedState?> =
            arrayOfNulls(size)
    }
}