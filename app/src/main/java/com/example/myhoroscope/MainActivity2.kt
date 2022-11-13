package com.example.myhoroscope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.myhoroscope.databinding.ActivityMain2Binding
import com.example.myhoroscope.model.Usuario
import java.text.SimpleDateFormat
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private val fechasRata = listOf(1936, 1948, 1960, 1972, 1984, 1996, 2008)
    private val fechasBuey = listOf(1937, 1949, 1961, 1973, 1985, 1997, 2009)
    private val fechasTigre = listOf(1938, 1950, 1962, 1974, 1986, 1998, 2010)
    private val fechasConejo = listOf(1939, 1951, 1963, 1975, 1987, 1999, 2011)
    private val fechasDragon = listOf(1940, 1952, 1964, 1976, 1988, 2000, 2012)
    private val fechasSerpiente = listOf(1941, 1953, 1965, 1977, 1989, 2001, 2013)
    private val fechasCaballo = listOf(1942, 1954, 1966, 1978, 1990, 2002, 2014)
    private val fechasCabra = listOf(1943, 1955, 1967, 1979, 1991, 2003, 2015)
    private val fechasMono = listOf(1944, 1956, 1968, 1980, 1992, 2004, 2016)
    private val fechasGallo = listOf(1945, 1957, 1969, 1981, 1993, 2005, 2017)
    private val fechasPerro = listOf(1946, 1958, 1970, 1982, 1994, 2006, 2018)
    private val fechasCerdo = listOf(1947, 1959, 1971, 1983, 1995, 2007, 2019)

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val user = bundle?.getParcelable<Usuario>("user")

        binding.tvNombre.text = user?.nombre

        val zodiacal = calculaZodiacal(user?.dia,user?.mes)
        val chino = calculaChino(user?.anio)

        entregaResultados(user, chino, zodiacal)

    }

    fun calculaEdad(fecha: String): Long{
        var fechaNac = SimpleDateFormat("dd/MM/yyyy").parse(fecha)
        var fechaActual = Date(System.currentTimeMillis())
        var diferenciaFechas = fechaActual.time - fechaNac.time
        var segundos = diferenciaFechas/1000
        var minutos = segundos/60
        var horas = minutos/60
        var dias = horas/24
        var anios = dias/365
        return anios
    }
    
    fun calculaZodiacal(dia: Int?, mes: Int?): Int{
        if(dia != null){
            when(mes){
                1 -> {
                    return if(dia <=19) 1 else 2 //Capricornio o Acuario
                }

                2 -> {
                    return if(dia <=18) 2 else 3 //Acuario o Piscis
                }

                3 -> {
                    return if(dia <=20) 3 else 4 //Piscis o Aries
                }

                4 -> {
                    return if(dia <=19) 4 else 5 //Aries o Tauro
                }

                5 -> {
                    return if(dia <=21) 5 else 6 //Tauro o Geminis
                }

                6 -> {
                    return if(dia <=20) 6 else 7 //Geminis o Cancer
                }

                7 -> {
                    return if(dia <=22) 7 else 8 //Cancer o Leo
                }

                8 -> {
                    return if(dia <=22) 8 else 9 //Leo o Virgo
                }

                9 -> {
                    return if(dia <=22) 9 else 10 //Virgo o Libra
                }

                10 -> {
                    return if(dia <=22) 10 else 11 //Libra o Escorpio
                }

                11 -> {
                    return if(dia <=21) 11 else 12 //Escorpio o Sagitario
                }

                12 -> {
                    return if(dia <=21) 12 else 1 //Sagitario o Capricornio
                }
            }

        }
        return -1
    }

    fun calculaChino(year: Int?): Int{
        when(year){
            in fechasRata ->{ return 1 }
            in fechasBuey ->{ return 2 }
            in fechasTigre ->{ return 3 }
            in fechasConejo ->{ return 4 }
            in fechasDragon ->{ return 5 }
            in fechasSerpiente ->{ return 6 }
            in fechasCaballo ->{ return 7 }
            in fechasCabra ->{ return 8 }
            in fechasMono ->{ return 9 }
            in fechasGallo ->{ return 10 }
            in fechasPerro ->{ return 11 }
            in fechasCerdo ->{ return 12 }
            else ->{ return -1 }
        }
    }

    fun entregaResultados(user: Usuario?, chinoID: Int, zodiacalID: Int){
        //Se muestra la imagen y texto correspondiente al calendario chino
        when(chinoID){
            1->{ binding.ivRata.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.rata)}
            2 ->{ binding.ivBuey.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.buey)}
            3 ->{ binding.ivTigre.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.tigre)}
            4 ->{ binding.ivConejo.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.conejo)}
            5 ->{ binding.ivDragon.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.dragon)}
            6 ->{ binding.ivSerpiente.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.serpiente)}
            7 ->{ binding.ivCaballo.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.caballo)}
            8 ->{ binding.ivCabra.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.cabra)}
            9 ->{ binding.ivMono.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.mono)}
            10 ->{ binding.ivGallo.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.gallo)}
            11 ->{ binding.ivPerro.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.perro)}
            12 ->{ binding.ivCerdo.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.cerdo)}
            else ->{ Toast.makeText(this,"Error al calcular signo zodiacal chino",Toast.LENGTH_SHORT).show() }
        }

        //Se muestra la imagen y texto correspondiente al calendario chino
        when(zodiacalID){
            1->{ binding.ivCapricornio.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.capricornio)}
            2 ->{ binding.ivAcuario.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.acuario)}
            3 ->{ binding.ivPiscis.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.piscis)}
            4 ->{ binding.ivAries.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.aries)}
            5 ->{ binding.ivTauro.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.tauro)}
            6 ->{ binding.ivGeminis.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.geminis)}
            7 ->{ binding.ivCancer.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.cancer)}
            8 ->{ binding.ivLeo.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.leo)}
            9 ->{ binding.ivVirgo.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.virgo)}
            10 ->{ binding.ivLibra.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.libra)}
            11 ->{ binding.ivEscorpio.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.escorpio)}
            12 ->{ binding.ivSagitario.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.sagitario)}
            else ->{ Toast.makeText(this,"Error al calcular signo zodiacal",Toast.LENGTH_SHORT).show() }
        }

        binding.tvFechaN.text = user?.dia.toString() + "/" + user?.mes.toString() + "/" + user?.anio.toString()
        binding.tvEdad.text = calculaEdad("${user?.dia}/${user?.mes}/${user?.anio}").toString()
        binding.tvNumCuenta.text = user?.numCuenta.toString()
        binding.tvCorreo.text = user?.correo.toString()

    }

    fun click(view: View) {
        var intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)

    }
}