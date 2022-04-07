package com.cville

import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {
    lateinit var user: User

    fun setP1Ref(name: String, gender: String, location: String, withFamily: Boolean? = null){
        user.name = name
        user.gender = gender
        user.location = location
        user.withFamily = withFamily
        // TODO persons number
    }

    fun setP2Ref(helps: String){
        user.helps = helps
    }
}