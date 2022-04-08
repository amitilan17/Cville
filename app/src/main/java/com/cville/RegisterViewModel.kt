package com.cville

import android.util.Log
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    var user: User = User()

    init {

        Log.d("eilon", "222")
    }

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
    }
}