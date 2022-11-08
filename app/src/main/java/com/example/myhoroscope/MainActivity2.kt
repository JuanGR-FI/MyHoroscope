package com.example.myhoroscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.myhoroscope.databinding.ActivityMain2Binding
import com.example.myhoroscope.model.Usuario

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

        val chino = calculaChino(user?.anio)

        entregaResultados(user,chino)

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

    fun entregaResultados(user: Usuario?, chinoID: Int){
        when(chinoID){
            1->{ binding.ivRata.visibility = VISIBLE
                binding.tvResChino.text = "Rata"}
            2 ->{ binding.ivBuey.visibility = VISIBLE
                binding.tvResChino.text = "Buey"}
            3 ->{ binding.ivTigre.visibility = VISIBLE
                binding.tvResChino.text = "Tigre"}
            4 ->{ binding.ivConejo.visibility = VISIBLE
                binding.tvResChino.text = "Conejo"}
            5 ->{ binding.ivDragon.visibility = VISIBLE
                binding.tvResChino.text = "Dragón"}
            6 ->{ binding.ivSerpiente.visibility = VISIBLE
                binding.tvResChino.text = "Serpiente"}
            7 ->{ binding.ivCaballo.visibility = VISIBLE
                binding.tvResChino.text = "Caballo"}
            8 ->{ binding.ivCabra.visibility = VISIBLE
                binding.tvResChino.text = "Cabra"}
            9 ->{ binding.ivMono.visibility = VISIBLE
                binding.tvResChino.text = "Mono"}
            10 ->{ binding.ivGallo.visibility = VISIBLE
                binding.tvResChino.text = "Gallo"}
            11 ->{ binding.ivPerro.visibility = VISIBLE
                binding.tvResChino.text = "Perro"}
            12 ->{ binding.ivCerdo.visibility = VISIBLE
                binding.tvResChino.text = "Cerdo"}
            else ->{ Toast.makeText(this,"Error al calcular signo zodiacal chino",Toast.LENGTH_SHORT).show() }
        }
        binding.tvFechaN.text = binding.tvFechaN.text.toString() + (user?.dia.toString() + "/" + user?.mes.toString() + "/" + user?.anio.toString())
        binding.tvNumCuenta.text = binding.tvNumCuenta.text.toString() + user?.numCuenta.toString()
        binding.tvCorreo.text = binding.tvCorreo.text.toString() + user?.correo.toString()
    }
}