package com.example.quizgametdd

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizgametdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModel: GameViewModel = GameViewModel(object : GameRepository{
            override fun questionAndChoices(): QuestionAndChoices {
                TODO("Not yet implemented")
            }

            override fun saveUserChoice(index: Int) {
                TODO("Not yet implemented")
            }

            override fun check(): CorrectAndUserChoiceIndex {
                TODO("Not yet implemented")
            }

            override fun next() {
                TODO("Not yet implemented")
            }
        })

        with(binding) {

            firstChoiceButton.setOnClickListener {
                val uiState: GameUiState = viewModel.chooseFirst()
                uiState.update(binding = binding)
            }

            secondChoiceButton.setOnClickListener {
                val uiState: GameUiState = viewModel.chooseSecond()
                uiState.update(binding = binding)
            }

            threeChoiceButton.setOnClickListener {
                val uiState: GameUiState = viewModel.chooseThree()
                uiState.update(binding = binding)
            }

            fourChoiceButton.setOnClickListener {
                val uiState: GameUiState = viewModel.chooseFour()
                uiState.update(binding = binding)
            }

            checkButton.setOnClickListener {
                val uiState: GameUiState = viewModel.chooseCheck()
                uiState.update(binding = binding)
            }

            nextButton.setOnClickListener {
                val uiState: GameUiState = viewModel.chooseNext()
                uiState.update(binding = binding)
            }

            val uiState = viewModel.init()
            uiState.update(binding = binding)

        }
    }
}