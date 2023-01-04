package com.example.compozsitions.domain.usecases

import com.example.compozsitions.domain.models.GameSettings
import com.example.compozsitions.domain.models.Level
import com.example.compozsitions.domain.Repository

class GetGameSettingsUseCase(private val repository: Repository) {
    fun execute(level: Level): GameSettings = repository.getGameSettings(level)
}