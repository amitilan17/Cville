package com.cville

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class MainViewModel : ViewModel() {
    var user = Firebase.auth.currentUser
    private val db = FirebaseFirestore.getInstance()

    companion object {
        private const val USERS_COLLECTION_TAG = "Users"
    }

//    fun uploadUser(item: User) {
//        db.collection(USERS_COLLECTION_TAG)
//            .document(user!!.uid)
//            .set(item)
//    }

    fun loadUser() {
        db.collection(USERS_COLLECTION_TAG)
            .document(user!!.uid)
            .get()
            .addOnSuccessListener {
                it.toObject(User::class.java)
            }
            .addOnFailureListener {
            }
    }
}
