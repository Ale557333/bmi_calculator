package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)

        tvResult.text = result.toString()

        val classification: String = if (result <= 18.5f) {
            tvClassification.setTextColor(getColor(R.color.magreza))
            "MAGREZA"
        } else if (result > 18.5 && result <= 24.9f) {
            tvClassification.setTextColor(getColor(R.color.normal))
            "NORMAL"
        } else if (result > 25 && result <= 29.9f) {
            tvClassification.setTextColor((getColor(R.color.sobrepeso)))
            "SOBREPESO"
        } else if (result > 30 && result <= 39.9) {
            tvClassification.setTextColor(getColor(R.color.obesidade))
            "OBESIDADE"
        } else {
            tvClassification.setTextColor((getColor(R.color.grave)))
            "OBESIDADE GRAVE"
        }

        tvClassification.text = classification
    }
}