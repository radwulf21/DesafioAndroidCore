package com.example.desafioandroidcore.domain

import android.os.Parcel
import android.os.Parcelable

class Prato(val id: Int, var img: Int, var nome: String?, var descricao: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(img)
        parcel.writeString(nome)
        parcel.writeString(descricao)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Prato> {
        override fun createFromParcel(parcel: Parcel): Prato {
            return Prato(parcel)
        }

        override fun newArray(size: Int): Array<Prato?> {
            return arrayOfNulls(size)
        }
    }
}