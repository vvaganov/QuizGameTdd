package com.example.quizgametdd.view.question

import android.content.Context
import android.util.AttributeSet

class QuestionCustomTextView: androidx.appcompat.widget.AppCompatTextView, UpdateText {

    constructor(context:Context) : super(context)
        constructor(context: Context, attr: AttributeSet): super(context, attr)
        constructor(context: Context, attr: AttributeSet, defStyleAttr:Int): super(context, attr,defStyleAttr)

    override fun update(text: String) {
        this.text = text
    }

    override fun getFreezesText(): Boolean  = true
}

interface UpdateText{
    fun update(text:String)
}