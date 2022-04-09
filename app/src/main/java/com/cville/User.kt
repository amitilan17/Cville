package com.cville

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var uid: String = "1111",
    var image: String? = "",
    var role: String= "refugee",
    var name: String = "no name",
    var gender: String= "Male",
    var location: String= "Israel",
    var withFamily: Boolean?= null,
    var personsNumber: Int? = null,
    var helps: String= "",
    var phone: String= "0",
    var description: String = "",
    var connectionUid: String? = ""
): Parcelable
