package com.example.myhoroscope.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(
    var nombre: String?,
    var dia: Int?,
    var mes: Int?,
    var anio: Int?,
    var numCuenta: Int?,
    var correo: String?
): Parcelable