package com.example.quizgametdd

import android.app.Application

class QuizApp : Application() {
    lateinit var viewModel: GameViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = GameViewModel(GameRepository.Base())
    }
}