package com.example.quizgametdd.view.stats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizgametdd.QuizApp
import com.example.quizgametdd.databinding.FragmentGameBinding
import com.example.quizgametdd.databinding.FragmentGameOverBinding
import com.example.quizgametdd.view.game.NavigateToGame

class GameOverFragment : Fragment() {

    private var _binding: FragmentGameOverBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameOverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = (requireActivity().application as QuizApp).gameOverViewModel

        binding.statsTextView.update(viewModel.statsUiState)
        binding.newGameButton.setOnClickListener {
            (requireActivity() as NavigateToGame).navigateToGame()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}