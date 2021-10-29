package com.example.quisss

data class question (
    val id: Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThre: String,
    val optionFour: String,
    val correctOption: Int
)