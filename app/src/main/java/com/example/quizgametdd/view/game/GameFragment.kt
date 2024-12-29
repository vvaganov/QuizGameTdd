package com.example.quizgametdd.view.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizgametdd.QuizApp
import com.example.quizgametdd.databinding.FragmentGameBinding
import com.example.quizgametdd.view.stats.NavigateToGameOver

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var uiState: GameUiState

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val viewModel = (requireActivity().application as QuizApp).gameViewModel

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
                (requireActivity() as NavigateToGameOver).navigateToGameOver()
            }

            uiState = viewModel.init(savedInstanceState == null)
            update.invoke()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}