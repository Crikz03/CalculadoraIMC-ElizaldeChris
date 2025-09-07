package elizalde.chris.asignacion4_calculadora_imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTxtPeso: EditText = findViewById(R.id.editTxtPeso)
        val editTxtEstatura: EditText = findViewById(R.id.editTxtEstatura)
        val buttonCalcularImc: Button = findViewById(R.id.buttomCalcularImc)
        val txtResultado: TextView = findViewById(R.id.txtResultado)
        val txtCategoria: TextView = findViewById(R.id.txtCategoria)

        buttonCalcularImc.setOnClickListener {
            val pesoStr = editTxtPeso.text.toString()
            val estaturaStr = editTxtEstatura.text.toString()

            if (pesoStr.isEmpty() || estaturaStr.isEmpty()) {
                txtResultado.text = "Por favor ingresa peso y estatura"
                txtCategoria.text = ""
                txtCategoria.setBackgroundResource(android.R.color.transparent)
                return@setOnClickListener
            }

            val peso = pesoStr.toDouble()
            val estatura = estaturaStr.toDouble()

            if (peso <= 0 || estatura <= 0) {
                txtResultado.text = "Valores inválidos"
                txtCategoria.text = ""
                txtCategoria.setBackgroundResource(android.R.color.transparent)
                return@setOnClickListener
            }

            val imc = peso / (estatura * estatura)

            val (textoCategoria, colorCategoria) = when {
                imc < 18.5 -> "Bajo peso" to R.color.colorGreenish
                imc < 24.9 -> "Normal" to R.color.colorGreen
                imc < 29.9 -> "Sobrepeso" to R.color.colorYellow
                imc < 34.9 -> "Obesidad grado 1" to R.color.colorOrange
                imc < 39.9 -> "Obesidad grado 2" to R.color.colorRed
                else -> "Obesidad grado 3" to R.color.colorBrown
            }

            txtResultado.text = "Tu IMC es %.2f".format(imc)
            txtCategoria.text = textoCategoria
            txtCategoria.setBackgroundResource(colorCategoria)
        }

    }
}