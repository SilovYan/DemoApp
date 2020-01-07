package com.example.demoapp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.example.demoapp.R.styleable.some_strange_component_attributes
import kotlinx.android.synthetic.main.some_strange_component.view.*

class SomeStrangeComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.some_strange_component, this, true)

        initAttributes(attrs)

        mainText.setOnClickListener {
            Toast.makeText(
                context,
                "Тут текст ${mainText.text} размера ${mainText.textSize}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun initAttributes(attrs: AttributeSet?) {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                some_strange_component_attributes, 0, 0
            )

            val title = typedArray.getText(R.styleable.some_strange_component_attributes_main_text)
                .toString()
            val textSize = typedArray.getDimension(
                R.styleable.some_strange_component_attributes_text_size,
                10.0f
            )

            setText(title)
            setTextSize(textSize)

            typedArray.recycle()
        }
    }

    fun setText(text: String) {
        mainText.text = text
    }

    fun setTextSize(textSize: Float) {
        mainText.textSize = textSize
    }
}