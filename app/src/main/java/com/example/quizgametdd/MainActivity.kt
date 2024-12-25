package com.example.quizgametdd

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizgametdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var uiState: GameUiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val update: () -> Unit = {
            uiState.update(
                binding.questionTextView,
                binding.firstChoiceButton,
                binding.secondChoiceButton,
                binding.threeChoiceButton,
                binding.fourChoiceButton,
                binding.nextButton,
                binding.checkButton
            )
        }

        val viewModel = (application as QuizApp).viewModel

        with(binding) {

            firstChoiceButton.setOnClickListener {
                uiState = viewModel.chooseFirst()
                update.invoke()
            }

            secondChoiceButton.setOnClickListener {
                uiState = viewModel.chooseSecond()
                update.invoke()
            }

            threeChoiceButton.setOnClickListener {
                uiState = viewModel.chooseThree()
                update.invoke()
            }

            fourChoiceButton.setOnClickListener {
                uiState = viewModel.chooseFour()
                update.invoke()
            }

            checkButton.setOnClickListener {
                uiState = viewModel.chooseCheck()
                update.invoke()
            }

            nextButton.setOnClickListener {
                uiState = viewModel.chooseNext()
                update.invoke()
            }

            uiState = viewModel.init(savedInstanceState == null)
            update.invoke()
        }
    }
}
