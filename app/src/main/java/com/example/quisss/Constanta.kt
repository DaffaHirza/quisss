package com.example.quisss

object Constanta {
    fun getQuestion(): ArrayList<question>{
        val questionList = ArrayList<question>()

        val question1 = question(
            1,
            "Ibukota Indonesia?",
            "Jogja",
            "Jakarta",
            "Bandung",
            "Semarang",
            2
        )
        questionList.add(question1)

        val question2 = question(
            1,
            "Ibukota Jateng?",
            "Jogja",
            "Jakarta",
            "Bandung",
            "Semarang",
            2
        )
        questionList.add(question2)

        val question3 = question(
            1,
            "Ibukota Jabar?",
            "Jogja",
            "Jakarta",
            "Bandung",
            "Semarang",
            2
        )
        questionList.add(question3)
        return questionList
    }
}