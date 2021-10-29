package com.example.quisss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuestionActivity : AppCompatActivity() {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val btnsubmit: Button = findViewById(R.id.submit)
        val progressBar: ProgressBar = findViewById(R.id.progress_bar)
        val progressText: TextView = findViewById(R.id.progress_text)
        val Question: TextView = findViewById(R.id.question_text)
        val jwb1: TextView = findViewById(R.id.opt_1)
        val jwb2: TextView = findViewById(R.id.opt_2)
        val jwb3: TextView = findViewById(R.id.opt_3)
        val jwb4: TextView = findViewById(R.id.opt_4)

        mQuestionList = Constanta.getQuestion()
        setQuestions()

        jwb1.setOnClickListener(this)
        jwb2.setOnClickListener(this)
        jwb3.setOnClickListener(this)
        jwb4.setOnClickListener(this)
        btnsubmit.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestions(){

        val btnsubmit: Button = findViewById(R.id.submit)
        val progressBar: ProgressBar = findViewById(R.id.progress_bar)
        val progressText: TextView = findViewById(R.id.progress_text)
        val Question: TextView = findViewById(R.id.question_text)
        val jwb1: TextView = findViewById(R.id.opt_1)
        val jwb2: TextView = findViewById(R.id.opt_2)
        val jwb3: TextView = findViewById(R.id.opt_3)
        val jwb4: TextView = findViewById(R.id.opt_4)

        val question = mQuestionList!!.get((mCurrentPosition-1))

        defaultOptionView()

        if(mCurrentPosition == mQuestionList!!.size)
        {
            btnsubmit.text="Finish"
        }
        else
        {
            btnsubmit.text="Submit"
        }


        progressBar.progress = mCurrentPosition
        progressText.text = "$mCurrentPosition" + "/" + progressBar.max
        Question.text = question.question
        jwb1.text = question.optionOne
        jwb2.text = question.optionTwo
        jwb3.text = question.optionThre
        jwb4.text = question.optionFour
    }

    override fun onClick(v: View?){
        val jwb1: TextView = findViewById(R.id.opt_1)
        val jwb2: TextView = findViewById(R.id.opt_2)
        val jwb3: TextView = findViewById(R.id.opt_3)
        val jwb4: TextView = findViewById(R.id.opt_4)
        val btnsubmit: Button = findViewById(R.id.submit)


        if (v != null) {
            when(v.id){

                R.id.opt_1 -> {
                    selectedOptionView(jwb1,1)
                }
                R.id.opt_2 -> {
                    selectedOptionView(jwb2,2)
                }
                R.id.opt_3 -> {
                    selectedOptionView(jwb3,3)
                }
                R.id.opt_4 -> {
                    selectedOptionView(jwb4,4)
                }
                R.id.submit -> {
                    if(mSelectedOptionPosition == 0){

                        when{
                            mCurrentPosition<=mQuestionList!!.size -> {
                                setQuestions()
                            }
                            else -> {
                                Toast.makeText(this, "kamu telah berhasil menyelesaikan quiz ini", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            }
                        }
                    }
                    else{
                        val question = mQuestionList?.get(mCurrentPosition -1)
                        if(question!!.correctOption != mSelectedOptionPosition){
                            answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                        }
                        answerView(question.correctOption,R.drawable.correct_option_border_bg)
                        if (mCurrentPosition == mQuestionList!!.size){
                            btnsubmit.text = "Finish"
                        }
                        else{
                            btnsubmit.text = "Lanjut Pertnyaan"
                        }
                        mSelectedOptionPosition
                    }
                }
            }
        }
    }



    private fun defaultOptionView(){
        val jwb1: TextView = findViewById(R.id.opt_1)
        val jwb2: TextView = findViewById(R.id.opt_2)
        val jwb3: TextView = findViewById(R.id.opt_3)
        val jwb4: TextView = findViewById(R.id.opt_4)

        val options = ArrayList<TextView>()
        options.add(0,jwb1)
        options.add(1,jwb2)
        options.add(2,jwb3)
        options.add(3,jwb4)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }
    private fun selectedOptionView(tv: TextView,selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
    private fun answerView(answer: Int, drawableView: Int){

        val jwb1: TextView = findViewById(R.id.opt_1)
        val jwb2: TextView = findViewById(R.id.opt_2)
        val jwb3: TextView = findViewById(R.id.opt_3)
        val jwb4: TextView = findViewById(R.id.opt_4)

        when(answer){
            1 -> {
                jwb1.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                jwb2.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                jwb3.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                jwb4.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

}
}