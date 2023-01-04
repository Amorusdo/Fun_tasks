package com.example.compozsitions.domain.usecases

import com.example.compozsitions.domain.Repository

class GenerateQuestionUseCase(private val repository: Repository) {
    fun execute(maxSumValue :Int): Question = repository.generateQuestion(maxSumValue, Utils.COUNT_OF_OPTIONS)


}