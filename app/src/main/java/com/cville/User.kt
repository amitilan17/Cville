package com.cville

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val uid: String = "",
    val name: String = "",
    val image: String? = "",
    val description: String = "",
    val connectionUid: String? = ""
): Parcelable
