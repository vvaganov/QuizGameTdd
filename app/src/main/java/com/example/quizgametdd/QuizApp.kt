package com.example.quizgametdd

import android.app.Application

class QuizApp : Application() {
    lateinit var viewModel: GameViewModel

    override fun onCreate() {
        super.onCreate()
        val sharePreferences = this.getSharedPreferences("quizAppData", MODE_PRIVATE)
        viewModel = GameViewModel(GameRepository.Base(
            IntCash.Base(key = "indexKey", defaultValue = 0, sharedPreferences =  sharePreferences),
            IntCash.Base(key = "userChoiceIndexKey", defaultValue = -1, sharedPreferences = sharePreferences)
        ))
    }
}