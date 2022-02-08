package br.senai.sp.jandira.controle_notas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        sair.setOnClickListener(){
            finish()
        }

        calcular.setOnClickListener(){
            val nota1 = findViewById<EditText>(R.id.nota1).text.toString().toInt()
            val nota2 = findViewById<EditText>(R.id.nota2).text.toString().toInt()
            val faltas = findViewById<EditText>(R.id.faltas).text.toString().toInt()
            val tabelaValores = findViewById<TextView>(R.id.tabelaValores)
            val resultadoAprovado = "Aprovado!"
            val resultadoReprovado = "Reprovado!"
            val media = (nota1 + nota2) / 2

            if (media >= 5){
                tabelaValores.text = "Nota 1: " +nota1 + "\n" +
                        "Nota 2: " +nota2 + "\n" +
                        "Faltas: " +faltas + "\n" +
                        "Média: " +media + "\n" +
                        "Situação: " +resultadoAprovado
                //resultado.setTextColor(Color.RED)

            } else{
                tabelaValores.text = "Nota 1: " +nota1 + "\n" +
                        "Nota 2: " +nota2 + "\n" +
                        "Faltas: " +faltas + "\n" +
                        "Média: " +media + "\n" +
                        "Situação: " + resultadoReprovado
                //resultado.setTextColor(Color.RED)
            }
        }
    }
}