package com.example.quizgametdd.view.visibilityButton


import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.os.Build

class VisibilitySavedState : View.BaseSavedState {

    private lateinit var state: VisibilityUiState

    constructor(superState: Parcelable) : super(superState)

      private constructor(parcelIn: Parcel) : super(parcelIn) {
       state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             parcelIn.readSerializable(VisibilityUiState::class.java.classLoader, VisibilityUiState::class.java) as VisibilityUiState
        } else {
           parcelIn.readSerializable() as VisibilityUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): VisibilityUiState = state

    fun save(uiState: VisibilityUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<VisibilitySavedState> {
        override fun createFromParcel(parcel: Parcel): VisibilitySavedState =
            VisibilitySavedState(parcel)

        override fun newArray(size: Int): Array<VisibilitySavedState?> =
            arrayOfNulls(size)
    }
}
