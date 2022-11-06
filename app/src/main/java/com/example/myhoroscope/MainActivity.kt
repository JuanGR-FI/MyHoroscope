package com.example.myhoroscope

import android.media.MediaCodec
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.example.myhoroscope.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var flag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etDatePicker.setOnClickListener{
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment {day,month,year -> onDateSelected(day,month,year)}
        datePicker.show(supportFragmentManager,"datePicker")
    }

    fun onDateSelected(day: Int, month: Int, year: Int){
        binding.etDatePicker.setText("$day/$month/$year")
        //binding.etDatePicker.text = "$day/$month/$year"
    }

    fun click(view: View) {
        flag = true
        if(binding.etNombre.text.isNotEmpty()){
            val nombre = binding.etNombre.text.toString()
        }else{
            Toast.makeText(this@MainActivity,"Por favor ingresa tu nombre",Toast.LENGTH_SHORT).show()
            binding.etNombre.error = "Se requiere un nombre"
            flag = false
        }
        if(binding.etDatePicker.text.isEmpty()){
            Toast.makeText(this@MainActivity,"Por favor ingresa una fecha de nacimiento",Toast.LENGTH_SHORT).show()
            binding.etDatePicker.error = "Se requiere una fecha de nacimiento"
            flag = false
        }
        if(binding.etNumCuenta.text.isNotEmpty()){
            val nc = binding.etNumCuenta.text.toString()
            if(nc.length != 9){
                Toast.makeText(this@MainActivity,"Número de cuenta incompleto",Toast.LENGTH_SHORT).show()
                binding.etNumCuenta.error = "Se requiere un número de cuenta de 9 dígitos"
                flag = false
            }else{
                val nc = nc.toInt()
            }
        }else{
            Toast.makeText(this@MainActivity,"Por favor ingresa tu número de cuenta",Toast.LENGTH_SHORT).show()
            binding.etNumCuenta.error = "Se requiere un número de cuenta"
            flag = false
        }
        if(binding.etCorreo.text.isNotEmpty()){
            val correo = binding.etCorreo.text.toString()
            if(!PatternsCompat.EMAIL_ADDRESS.matcher(correo).matches()){
                Toast.makeText(this@MainActivity,"Por favor ingresa un correo electrónico válido",Toast.LENGTH_SHORT).show()
                binding.etCorreo.error = "Se requiere un correo electrónico válido"
                flag = false
            }
        }else{
            Toast.makeText(this@MainActivity,"Por favor ingresa un correo electrónico",Toast.LENGTH_SHORT).show()
            binding.etCorreo.error = "Se requiere un correo electrónico"
            flag = false
        }

        if(flag){
            Toast.makeText(this@MainActivity,"Todo correcto",Toast.LENGTH_SHORT).show()
        }
    }

    fun verificaValores(nombre: String, dia: Int, mes: Int, anio: Int, numCuenta: Int, correo: String){

    }
}