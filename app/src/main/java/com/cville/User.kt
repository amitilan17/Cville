package com.cville

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val uid: String,
    val name: String,
    val imageRes: Int,
    val description: String,
    val connectionUid: String?
): Parcelable
