package com.example.compozsitions.domain

import com.example.compozsitions.domain.models.GameSettings
import com.example.compozsitions.domain.models.Level
import com.example.compozsitions.domain.usecases.Question

interface Repository {
    fun generateQuestion(maxSumValue:Int, countOfOption: Int): Question
    fun getGameSettings(level: Level): GameSettings
}