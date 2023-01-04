package com.example.compozsitions.domain.models

import java.io.Serializable

data class GameResalt(
    val countOfRightAnswer: Int,
    val persentOfRightAnswer:Double,
    val countofQuestion:Int,
    val gameSettings: GameSettings,
): Serializable
