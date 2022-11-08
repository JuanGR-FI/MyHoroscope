package com.example.myhoroscope.model

import android.os.Parcel
import android.os.Parcelable

data class Usuario(
    var nombre: String?,
    var dia: Int?,
    var mes: Int?,
    var anio: Int?,
    var numCuenta: Int?,
    var correo: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeValue(dia)
        parcel.writeValue(mes)
        parcel.writeValue(anio)
        parcel.writeValue(numCuenta)
        parcel.writeString(correo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }
}
