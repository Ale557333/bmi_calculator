package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)

        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        btnCalculate.setOnClickListener {
            val weightStr: String = edtWeight.text.toString()
            val heightStr: String = edtHeight.text.toString()

            if (weightStr == "" || heightStr == "") {
                //mostrar mensagem para usuario informando
                Snackbar.make(
                    edtWeight,
                    "Preencher todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {
                val weight: Float = weightStr.toFloat()
                val height: Float = heightStr.toFloat()

                val height2 = height * height
                val bmi = weight / height2

                println("O resultado é " + bmi)
            }

        }
    }
}