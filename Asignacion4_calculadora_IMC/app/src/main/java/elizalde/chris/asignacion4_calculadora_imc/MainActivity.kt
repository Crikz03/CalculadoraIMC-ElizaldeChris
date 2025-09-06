package elizalde.chris.asignacion4_calculadora_imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var peso = 0;

    var estatura = 0;

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

        buttonCalcularImc.setOnClickListener {



        }

    }
}