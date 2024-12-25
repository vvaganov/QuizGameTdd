package com.example.quizgametdd

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class ScenarioUiTest {

    private lateinit var gamePage: GamePage

    @Before
    fun setup(){
        gamePage = GamePage(
            question = "What color is the sky ",
            choices = listOf("blue", "green", "red", "yellow")
        )
    }

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * Test case number1
     */

    @Test
    fun caseNumber1() {

        gamePage.assertAskQuestionState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAskQuestionState()

        gamePage.clickFirstChoice()
        gamePage.assertFirstChoiceMakeState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertFirstChoiceMakeState()

        gamePage.clickCheck()
        gamePage.assertAnswerChoiceStateFirstCorrect()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAnswerChoiceStateFirstCorrect()
    }

    @Test
    fun caseNumber2(){

        gamePage.assertAskQuestionState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAskQuestionState()

        gamePage.clickFirstChoice()
        gamePage.assertFirstChoiceMakeState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertFirstChoiceMakeState()


        gamePage.clickSecondChoice()
        gamePage.assertSecondChoiceMakeState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertSecondChoiceMakeState()

        gamePage.clickCheck()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()

        gamePage.clickNext()

        gamePage = GamePage(
            question = "What color is the sky grass ",
            choices = listOf("green", "blue", "red", "yellow")
        )

        gamePage.assertAskQuestionState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAskQuestionState()

    }

    @Test
    fun caseNumber3(){

        gamePage.assertAskQuestionState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAskQuestionState()

        gamePage.clickFirstChoice()
        gamePage.assertFirstChoiceMakeState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertFirstChoiceMakeState()

        gamePage.clickCheck()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()

        gamePage.clickNext()

        gamePage = GamePage(
            question = "What color is the sky grass",
            choices = listOf("green", "blue", "red", "yellow")
        )

        gamePage.assertAskQuestionState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAskQuestionState()

        gamePage.clickFirstChoice()
        gamePage.assertFirstChoiceMakeState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertFirstChoiceMakeState()

        gamePage.clickCheck()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()

        gamePage.clickNext()
        gamePage.assertNotVisible()

        var gameOverPage = GameOverPage(correct = 2, incorrect = 0)

        gameOverPage.assertInitialGameOverState()
        activityScenarioRule.scenario.recreate()
        gameOverPage.assertInitialGameOverState()

        gameOverPage.clickNewGame()
        gameOverPage.assertNotVisible()

        gamePage = GamePage(
            question = "What color is the sky sun ",
            choices = listOf("yellow", "blue", "red", "green")
        )

        gamePage.assertAskQuestionState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAskQuestionState()

        gamePage.clickSecondChoice()
        gamePage.assertSecondChoiceMakeState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertSecondChoiceMakeState()

        gamePage.clickCheck()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()

        gamePage.clickNext()

        gamePage = GamePage(
            question = "What color is the sky crocodile ",
            choices = listOf("green", "blue", "red", "yellow")
        )

        gamePage.assertAskQuestionState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAskQuestionState()

        gamePage.clickSecondChoice()
        gamePage.assertSecondChoiceMakeState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertSecondChoiceMakeState()

        gamePage.clickCheck()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()

        gamePage.clickNext()
        gamePage.assertNotVisible()

        gameOverPage = GameOverPage(correct = 0, incorrect = 2)

        gameOverPage.assertInitialGameOverState()
        activityScenarioRule.scenario.recreate()
        gameOverPage.assertInitialGameOverState()

        gameOverPage.clickNewGame()
        gameOverPage.assertNotVisible()

        gamePage = GamePage(
            question = "What color is the sky blood ",
            choices = listOf("red", "blue", "green", "yellow")
        )

        gamePage.assertAskQuestionState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAskQuestionState()

        gamePage.clickFirstChoice()
        gamePage.assertFirstChoiceMakeState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertFirstChoiceMakeState()

        gamePage.clickCheck()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()

        gamePage.clickNext()

        gamePage = GamePage(
            question = "What color is the sky water",
            choices = listOf("blue", "red", "green", "yellow")
        )

        gamePage.assertAskQuestionState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAskQuestionState()

        gamePage.clickSecondChoice()
        gamePage.assertSecondChoiceMakeState()
        activityScenarioRule.scenario.recreate()
        gamePage.assertSecondChoiceMakeState()

        gamePage.clickCheck()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()
        activityScenarioRule.scenario.recreate()
        gamePage.assertAnswerChoiceStateFirstCorrectSecondInCorrect()

        gamePage.clickNext()
        gamePage.assertNotVisible()

        gameOverPage = GameOverPage(correct = 1, incorrect = 1)
        gameOverPage.assertInitialGameOverState()
        activityScenarioRule.scenario.recreate()
        gameOverPage.assertInitialGameOverState()


















    }
}