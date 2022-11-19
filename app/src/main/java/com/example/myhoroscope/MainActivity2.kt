package com.example.myhoroscope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.view.isVisible
import com.blogspot.atifsoftwares.animatoolib.Animatoo
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
        val fechaNac = SimpleDateFormat("dd/MM/yyyy").parse(fecha)
        val fechaActual = Date(System.currentTimeMillis())
        val diferenciaFechas = fechaActual.time - fechaNac.time
        val segundos = diferenciaFechas/1000
        val minutos = segundos/60
        val horas = minutos/60
        val dias = horas/24
        val anios = dias/365
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
        lateinit var imageZ: View
        lateinit var imageC: View
        val anim = AnimationUtils.loadAnimation(this, R.anim.scale_image)
        //Se muestra la imagen y texto correspondiente al calendario chino
        when(chinoID){
            1->{ binding.ivRata.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.rata)
                imageC = binding.ivRata}
            2 ->{ binding.ivBuey.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.buey)
                imageC = binding.ivBuey}
            3 ->{ binding.ivTigre.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.tigre)
                imageC = binding.ivTigre}
            4 ->{ binding.ivConejo.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.conejo)
                imageC = binding.ivConejo}
            5 ->{ binding.ivDragon.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.dragon)
                imageC = binding.ivDragon}
            6 ->{ binding.ivSerpiente.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.serpiente)
                imageC = binding.ivSerpiente}
            7 ->{ binding.ivCaballo.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.caballo)
                imageC = binding.ivCaballo}
            8 ->{ binding.ivCabra.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.cabra)
                imageC = binding.ivCabra}
            9 ->{ binding.ivMono.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.mono)
                imageC = binding.ivMono}
            10 ->{ binding.ivGallo.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.gallo)
                imageC = binding.ivGallo}
            11 ->{ binding.ivPerro.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.perro)
                imageC = binding.ivPerro}
            12 ->{ binding.ivCerdo.visibility = VISIBLE
                binding.tvResChino.text = resources.getString(R.string.cerdo)
                imageC = binding.ivCerdo}
            else ->{ Toast.makeText(this,"Error al calcular signo zodiacal chino",Toast.LENGTH_SHORT).show() }
        }

        //Se muestra la imagen y texto correspondiente al calendario chino
        when(zodiacalID){
            1->{ binding.ivCapricornio.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.capricornio)
                imageZ = binding.ivCapricornio}
            2 ->{ binding.ivAcuario.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.acuario)
                imageZ = binding.ivAcuario}
            3 ->{ binding.ivPiscis.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.piscis)
                imageZ = binding.ivPiscis}
            4 ->{ binding.ivAries.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.aries)
                imageZ = binding.ivAries}
            5 ->{ binding.ivTauro.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.tauro)
                imageZ = binding.ivTauro}
            6 ->{ binding.ivGeminis.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.geminis)
                imageZ = binding.ivGeminis}
            7 ->{ binding.ivCancer.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.cancer)
                imageZ = binding.ivCancer}
            8 ->{ binding.ivLeo.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.leo)
                imageZ = binding.ivLeo}
            9 ->{ binding.ivVirgo.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.virgo)
                imageZ = binding.ivVirgo}
            10 ->{ binding.ivLibra.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.libra)
                imageZ = binding.ivLibra}
            11 ->{ binding.ivEscorpio.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.escorpio)
                imageZ = binding.ivEscorpio}
            12 ->{ binding.ivSagitario.visibility = VISIBLE
                binding.tvResZodiacal.text = resources.getString(R.string.sagitario)
                imageZ = binding.ivSagitario}
            else ->{ Toast.makeText(this,"Error al calcular signo zodiacal",Toast.LENGTH_SHORT).show() }
        }

        binding.tvFechaN.text = user?.dia.toString() + "/" + user?.mes.toString() + "/" + user?.anio.toString()
        binding.tvEdad.text = calculaEdad("${user?.dia}/${user?.mes}/${user?.anio}").toString()
        binding.tvNumCuenta.text = user?.numCuenta.toString()
        binding.tvCorreo.text = user?.correo.toString()

        imageC.startAnimation(anim)
        imageZ.startAnimation(anim)

    }

    fun click(view: View) {
        var intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        Animatoo.animateZoom(this)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        Animatoo.animateZoom(this)
    }
}