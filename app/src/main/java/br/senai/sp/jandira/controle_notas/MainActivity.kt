package br.senai.sp.jandira.controle_notas

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private lateinit var nota1EditText: EditText
private lateinit var nota2EditText: EditText
private lateinit var nomeUsuarioEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)
        sair.setOnClickListener() {
            finish()
        }

        calcular.setOnClickListener() {

            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)
            nomeUsuarioEditText = findViewById(R.id.nomeUsuario)

            if (validarCampos()) {

                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()
                val nomeUsuario = nomeUsuarioEditText.text.toString()
                val tabelaValoresTextView = findViewById<TextView>(R.id.tabelaValores)
                val media = calcularMedia(nota1, nota2)
                tabelaValoresTextView.text = situacaoAluno(media)

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra( "nome", nomeUsuarioEditText.text.toString())
                intent.putExtra("nota1", nota1.toString())
                intent.putExtra("nota2", nota2.toString())
                intent.putExtra("media", media.toString())
                intent.putExtra("situacao", situacaoAluno(media))
                startActivity(intent)


//                if (media >= 5) {
//                    tabelaValoresTextView.text = "Nome: " +nomeUsuario + "\n" +
//                            "Nota 1: " + nota1 + "\n" +
//                            "Nota 2: " + nota2 + "\n" +
//                            "Média: " + media + "\n" +
//                            "Situação: " + "Aprovado"
//
//                } else {
//                    tabelaValoresTextView.text = "Nome: " +nomeUsuario +
//                            "Nota 1: " + nota1 + "\n" +
//                            "Nota 2: " + nota2 + "\n" +
//                            "Média: " + media + "\n"  +
//                            "Situação: " + "Reprovado"
//
//                }

            }

        }

    }


    private fun validarCampos(): Boolean {
        var noError = true

        if (nota1EditText.text.isBlank()){
            nota1EditText.setError("Digite a nota 1")
            noError = false
        }

        if (nota2EditText.text.isBlank()){
            nota2EditText.setError("Digite a nota 2")
            noError = false
        }

        if (nomeUsuarioEditText.text.isBlank()){
            nomeUsuarioEditText.setError("Digite seu nome")
            noError = false
        }

        return noError
    }

}

