package com.cville

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var uid: String = "",
    var image: String? = "",
    var role: String= "",
    var name: String = "",
    var gender: String= "",
    var location: String= "",
    var withFamily: Boolean?= null,
    var personsNumber: Int? = null,
    var helps: String= "",
    var phone: String= "",
    var description: String = "",
    var connectionUid: String? = ""
): Parcelable
