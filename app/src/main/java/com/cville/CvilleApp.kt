package com.cville

import android.app.Application
import androidx.activity.ComponentActivity
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract

//import com.google.firebase.FirebaseApp

class CvilleApp : Application() {


    override fun onCreate() {
        super.onCreate()

//        FirebaseApp.initializeApp(this)
    }

//    fun initAuth(act: ComponentActivity) {
//
//        val signInLauncher = act.registerForActivityResult(
//            FirebaseAuthUIActivityResultContract()
//        ) { res ->
//            this.onSignInResult(res)
//        }
//
//    }

}