package com.cville

import android.app.Application
import android.os.Debug
import android.util.Log
import androidx.activity.ComponentActivity
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.google.firebase.FirebaseApp

//import com.google.firebase.FirebaseApp

class CvilleApp : Application() {


    override fun onCreate() {
        super.onCreate()
        Log.d("eilon", "App called")
//        FirebaseApp.initializeApp(this)
    }

}