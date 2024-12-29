package com.example.quizgametdd

import android.app.Application
import com.example.quizgametdd.view.game.GameRepository
import com.example.quizgametdd.view.game.GameViewModel
import com.example.quizgametdd.view.stats.GameOverViewModel

class QuizApp : Application() {
    lateinit var gameViewModel: GameViewModel
    lateinit var gameOverViewModel: GameOverViewModel

    override fun onCreate() {
        super.onCreate()
        val sharePreferences = this.getSharedPreferences("quizAppData", MODE_PRIVATE)
        gameViewModel = GameViewModel(
            GameRepository.Base(
            IntCash.Base(key = "indexKey", defaultValue = 0, sharedPreferences =  sharePreferences),
            IntCash.Base(key = "userChoiceIndexKey", defaultValue = -1, sharedPreferences = sharePreferences)
        ))

        gameOverViewModel = GameOverViewModel()
    }
}