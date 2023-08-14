package me.ylvox.appconsole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity() : AppCompatActivity(), View.OnClickListener {

    lateinit var txt1: EditText
    lateinit var txt2: EditText
    lateinit var radio: RadioGroup
    lateinit var radioBtn: RadioButton
    lateinit var textConsole: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt1 = findViewById(R.id.txt1)
        txt2 = findViewById(R.id.txt2)
        radio = findViewById(R.id.radioGroup)
        var btnProcessar: Button = findViewById(R.id.btnProcessar)
        btnProcessar.setOnClickListener(this)
        textConsole = findViewById(R.id.textConsole)
    }
    fun somar(a: Int, b: Int): String{
        return "${a + b}"
    }

    fun subtrair(a: Int, b: Int): String{
        return "${a - b}"
    }

    fun dividir(a: Float, b: Float): String{
        return "${a / b}"
    }

    fun multiplicar(a: Float, b: Float): String{
        return "${a * b}"
    }

    fun calcular(id: Int, a: String, b:String): String{
        if(id != -1){
            radioBtn = findViewById(id)
            val resposta = when(radioBtn.text.toString()) {
                "*" -> multiplicar(a.toFloat(), b.toFloat())
                "/" -> dividir(a.toFloat(), b.toFloat())
                "-" -> subtrair(a.toInt(), b.toInt())
                "+" -> somar(a.toInt(), b.toInt())
                else -> "Invalido"
            }
            return resposta
        }else{
            return "Nada selecionado"
        }
    }

//    fun concatenar(a: String, b: String): String{
//        return "$a $b"
//    }
//
//    fun listar(contador: Int, texto: String): MutableList<String> {
//        var lista = mutableListOf<String>()
//        for (i in 1..contador){
//            lista.add("$texto $i")
//        }
//        return lista
//    }
//
//    class Pessoa(val nome: String, val idade: Int)
//
//    fun listarPessoas(nome: String, contador: Int): MutableList<Pessoa>{
//        var lista = mutableListOf<Pessoa>()
//        for (i in 1..contador){
//            lista.add(Pessoa(nome, 23))
//        }
//        return lista
//    }
//
//    fun getStringPessoas(lista: MutableList<Pessoa>): String{
//        var pessoas: String = ""
//        for (p in lista){
//            pessoas += "${p.nome} - ${p.idade} \n"
//        }
//        return pessoas
//    }

    override fun onClick(v: View?) {
        val radioBtnId: Int = radio.checkedRadioButtonId
        val a = txt1.text.toString()
        val b = txt2.text.toString()
        textConsole.text = calcular(radioBtnId, a, b)
    }

}