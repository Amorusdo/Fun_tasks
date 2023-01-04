package com.example.compozsitions.data

import com.example.compozsitions.domain.models.GameSettings
import com.example.compozsitions.domain.models.Level
import com.example.compozsitions.domain.usecases.Question
import com.example.compozsitions.domain.Repository
import com.example.compozsitions.domain.usecases.Utils
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class RepositoryImpl : Repository {
    override fun generateQuestion(maxSumValue: Int, countOfOption: Int): Question {
       val sum = Random.nextInt(Utils.MIN_COUNT_VALUE,  Utils.MIN_SUM_VALUE + maxSumValue)
        val visibleNum =Random.nextInt(Utils.MIN_SUM_VALUE,sum)
        val options = HashSet<Int>()
        val rightAnswer =sum-visibleNum
        val from = max(rightAnswer- countOfOption, Utils.MIN_SUM_VALUE)
        val to= min(maxSumValue,rightAnswer + countOfOption)
        options.add(rightAnswer)
        while (options.size<countOfOption){
            options.add(Random.nextInt(from,to))
        }
        return Question(
            sum,visibleNum,options.toList()
        )

    }

    override fun getGameSettings(level: Level): GameSettings {
       return when (level) {
            Level.TEST -> GameSettings(
                10,
                4,
                40.0,
                10
            )
            Level.EASY -> GameSettings(
                20,
                8,
                50.0,
                20
            )
            Level.STANDART -> GameSettings(
                30,
                15,
                60.0,
                40
            )
            Level.HARD -> GameSettings(
                40,
                25,
                70.0,
                60
            )
        }
    }
}