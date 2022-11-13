package com.example.myhoroscope

import android.app.DatePickerDialog
import android.content.Intent
import android.media.MediaCodec
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.example.myhoroscope.databinding.ActivityMainBinding
import com.example.myhoroscope.model.Usuario
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var flag = true
    private var dateFlag = false
    private var day = 0
    private var month = 0
    private var year = 0
    private var minDate: Long = 0
    private var maxDate: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.etDatePicker.setOnClickListener{
            showDatePickerDialog()
        }*/
        val myCalendar = Calendar.getInstance()
        
        val datePicker = DatePickerDialog.OnDateSetListener{view,year,month,dayOfMonth ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }

        binding.etDatePicker.setOnClickListener {
            val picker = DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH))
            if(!dateFlag){
                myCalendar.add(Calendar.YEAR, -2)
                picker.datePicker.maxDate = myCalendar.timeInMillis
                minDate = picker.datePicker.maxDate
            }
            picker.datePicker.maxDate = minDate
            picker.show()
        }

    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.ROOT)
        binding.etDatePicker.setText(sdf.format(myCalendar.time))

        this.day = myCalendar.get(Calendar.DAY_OF_MONTH)
        this.month = myCalendar.get(Calendar.MONTH)
        this.year = myCalendar.get(Calendar.YEAR)

        myCalendar.set(Calendar.YEAR,this.year)
        myCalendar.set(Calendar.MONTH,this.month)
        myCalendar.set(Calendar.DAY_OF_MONTH, this.day)
        dateFlag = true
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment {day,month,year -> onDateSelected(day,month,year)}
        datePicker.show(supportFragmentManager,"datePicker")
    }

    fun onDateSelected(d: Int, m: Int, y: Int){
        binding.etDatePicker.setText("$d/${m+1}/$y")
        day = d
        month = m + 1
        year = y
        //binding.etDatePicker.text = "$day/$month/$year"
    }

    fun click(view: View) {
        var nombre = ""
        var nc = ""
        var correo = ""
        flag = true
        if(binding.etNombre.text.isNotEmpty()){
            nombre = binding.etNombre.text.toString()
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
            nc = binding.etNumCuenta.text.toString()
            if(nc.length != 9){
                Toast.makeText(this@MainActivity,"Número de cuenta incompleto",Toast.LENGTH_SHORT).show()
                binding.etNumCuenta.error = "Se requiere un número de cuenta de 9 dígitos"
                flag = false
            }
        }else{
            Toast.makeText(this@MainActivity,"Por favor ingresa tu número de cuenta",Toast.LENGTH_SHORT).show()
            binding.etNumCuenta.error = "Se requiere un número de cuenta"
            flag = false
        }
        if(binding.etCorreo.text.isNotEmpty()){
            correo = binding.etCorreo.text.toString()
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
            binding.givLoading.visibility = VISIBLE

            //startActivity(intent)

            thread{
                Thread.sleep(500)
                val intent = Intent(this, MainActivity2::class.java)

                val usuario = Usuario(nombre,day, month+1, year,nc.toInt(), correo)
                val parametros = Bundle()
                parametros.putParcelable("user", usuario)
                intent.putExtras(parametros)
                startActivity(intent)
                binding.givLoading.visibility = INVISIBLE

            }
        }
    }
}