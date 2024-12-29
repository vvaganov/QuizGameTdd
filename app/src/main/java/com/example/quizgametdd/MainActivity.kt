package com.example.quizgametdd

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizgametdd.databinding.ActivityMainBinding
import com.example.quizgametdd.view.game.GameScreen
import com.example.quizgametdd.view.game.NavigateToGame
import com.example.quizgametdd.view.stats.GameOverScreen
import com.example.quizgametdd.view.stats.NavigateToGameOver

class MainActivity : AppCompatActivity(), Navigate {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.fragmentContainer) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState == null){
            navigateToGame()
        }
    }

    override fun navigate(screen: Screen) {
        screen.show(R.id.fragment_container, supportFragmentManager)
    }
}



interface Navigate : NavigateToGame, NavigateToGameOver {

    fun navigate(screen: Screen)

    override fun navigateToGame() {
        navigate(GameScreen)
    }

    override fun navigateToGameOver() {
        navigate(GameOverScreen)
    }
}





