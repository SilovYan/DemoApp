package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pushable_button.setOnClickListener {
            val component = SomeStrangeComponent(applicationContext)
            component.setText("Какой-то случайный текст " + counter++)
            component.setTextSize(10f + counter)

            mainContainer.addView(component)
        }
    }
}
