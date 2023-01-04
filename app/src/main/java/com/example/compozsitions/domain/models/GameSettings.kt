package com.example.compozsitions.domain.models

import java.io.Serializable

data class GameSettings (
    val maxSumValue: Int,
    val minCountOfRingtAnsewer :Int,
    val minPercentOfRightAnser : Double,
    val gameTimeInSecond: Int
        ): Serializable
