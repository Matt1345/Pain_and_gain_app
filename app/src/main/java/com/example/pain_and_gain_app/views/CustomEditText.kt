package com.example.pain_and_gain_app.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.example.pain_and_gain_app.R

class CustomEditText(context: Context, attrs: AttributeSet?) : AppCompatEditText(context, attrs) {
    var customId: String? = null

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.CustomEditText)
            customId = typedArray.getString(R.styleable.CustomEditText_customId)
            typedArray.recycle()
        }
    }

    fun validateInput(): Boolean {
        if (text.isNullOrEmpty()) {
            error = "You must enter the value for this"
            return false
        }
        if (customId == null) {
            if (text.isNullOrEmpty()) {
                error = "Names cannot be empty"
                return false
            }
        } else if (customId == "nationality") {
            if (text.isNullOrEmpty()) {
                error = "Nationality cannot be left empty"
                return false
            }
        } else if (customId == "age") {
            val age = Integer.parseInt(text.toString())
            if (age < 18 || age > 60) {
                error = "We don't accept kids or old nutjobs, enter age between 18 and 60"
                return false
            }
        } else if (customId == "height" || customId == "weight") {
            val value = Integer.parseInt(text.toString())
            if (value < 50 || value > 300) {
                error = "Come on, enter some believable value"
                return false
            }
        }
        return true
    }
}