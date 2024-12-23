package com.example.quizgametdd

import com.example.quizgametdd.databinding.ActivityMainBinding

interface GameUiState {

   data  class AskQuestion(
       val question: String,
       val choices: List<String>
   ) :GameUiState {

    }

   data  class ChoiceMake(
       val question: String,
       val choices: List<ChoicesUiState>
   ) : GameUiState {

    }

   data  class AnswerCheck(
       val question: String,
       val choices: List<ChoicesUiState>
   ) : GameUiState {

    }

    fun update(binding: ActivityMainBinding) = Unit
}
