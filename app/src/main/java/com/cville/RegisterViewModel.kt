package com.cville

import android.os.Debug
import android.util.Log
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    private var user: User = User()

    fun setP1Ref(
        name: String,
        gender: String,
        location: String,
        personsNumber: Int,
        withFamily: Boolean? = null
    ) {
        user.name = name
        user.gender = gender
        user.location = location
        user.withFamily = withFamily
        user.personsNumber = personsNumber

        Log.d("eilon", user.toString())
    }

    fun setP2Ref(helps: String) {
        user.helps = helps
    }
}