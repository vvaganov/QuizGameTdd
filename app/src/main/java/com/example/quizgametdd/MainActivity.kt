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

        val viewModel = (application as QuizApp).viewModel

        with(binding) {

            firstChoiceButton.setOnClickListener {
                uiState = viewModel.chooseFirst()
                uiState.update(binding = binding)
            }

            secondChoiceButton.setOnClickListener {
                uiState = viewModel.chooseSecond()
                uiState.update(binding = binding)
            }

            threeChoiceButton.setOnClickListener {
                uiState = viewModel.chooseThree()
                uiState.update(binding = binding)
            }

            fourChoiceButton.setOnClickListener {
                uiState = viewModel.chooseFour()
                uiState.update(binding = binding)
            }

            checkButton.setOnClickListener {
                uiState = viewModel.chooseCheck()
                uiState.update(binding = binding)
            }

            nextButton.setOnClickListener {
                uiState= viewModel.chooseNext()
                uiState.update(binding = binding)
            }

            if (savedInstanceState == null) {
                uiState = viewModel.init()
                Log.i("!!!", "init state - $uiState")
            } else {
                uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    savedInstanceState.getSerializable(UI_STATE_KEY, GameUiState::class.java) as GameUiState
                } else{
                    savedInstanceState.getSerializable(UI_STATE_KEY)as GameUiState
                }
            }
            uiState.update(binding = binding)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(UI_STATE_KEY, uiState)
        Log.i("!!!", "save UI state - $uiState")

    }

    companion object {
       private const val UI_STATE_KEY = "uiState"
    }
}
