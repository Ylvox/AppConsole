package me.ylvox.appconsole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var txt1: EditText
    lateinit var txt2: EditText
    lateinit var textConsole: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt1 = findViewById(R.id.txt1)
        txt2 = findViewById(R.id.txt2)
        var btnProcessar: Button = findViewById(R.id.btnProcessar)
        btnProcessar.setOnClickListener(this)
        textConsole = findViewById(R.id.textConsole)
    }

    override fun onClick(v: View?) {
        var texto: String = txt1.text.toString() + txt2.text.toString()
        textConsole.text = texto
    }

}