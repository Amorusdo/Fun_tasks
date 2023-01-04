package com.example.compozsitions.domain.usecases

 data class Question (
  val sum : Int,
  val visibleNum: Int,
  val variants:List<Int>){
     val correctAnswer:Int
     get() = sum - visibleNum
 }


