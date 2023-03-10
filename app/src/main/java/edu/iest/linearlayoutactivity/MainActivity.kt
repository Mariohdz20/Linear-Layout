package edu.iest.linearlayoutactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var bnSuma : Button? = null
    private var bnResta : Button? = null
    private var etNumeroPrimero: EditText? = null
    private var etNumeroSegundo: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bnSuma = findViewById(R.id.bnSuma)
        bnResta = findViewById(R.id.bnResta)
        bnSuma?.setOnClickListener(this)
        bnResta?.setOnClickListener(this)
        asignarEventos()
        inicializarVistas()
    }

    private fun inicializarVistas(){
        bnSuma = findViewById(R.id.bnSuma)
        bnResta = findViewById(R.id.bnResta)
        etNumeroPrimero = findViewById(R.id.etNumeroPrimero)
        etNumeroSegundo = findViewById(R.id.etNumeroSegundo)
    }

    private fun asignarEventos(){
        bnSuma?.setOnClickListener(this)
        bnResta?.setOnClickListener(this)
    }



    override fun onClick(p0: View?) {
        val numeroUno = etNumeroPrimero?.text.toString().toFloatOrNull()
        val numeroDos = etNumeroSegundo?.text.toString().toFloatOrNull()

        val aritmetica = Aritmetica()

        when(p0?.id) {
            R.id.bnSuma -> {
                if (numeroUno != null && numeroDos != null) {
                    val suma = aritmetica.suma(numeroUno,numeroDos)
                    val mensaje = Mensajes("La sumatoria fue $suma",this)
                    mensaje.mostrarToast()
                }
                else{
                    Toast.makeText(this, "Pon números", Toast.LENGTH_LONG).show()
                }
            }

            R.id.bnResta -> {
                if (numeroUno != null && numeroDos != null) {
                    val resta = aritmetica.resta(numeroUno,numeroDos)
                    val mensaje = Mensajes("La resta fue $resta",this)
                    mensaje.mostrarSnackbar(p0)
                }
                else{
                    Toast.makeText(this, "Pon números", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}