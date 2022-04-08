package com.cville

import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class MainViewModel : ViewModel() {
    lateinit var user: User
    private val db = FirebaseFirestore.getInstance()

    companion object {
        private const val USERS_COLLECTION_TAG = "Users"
        fun setProfileImgToView(
            ctx: Context,
            profilePhotoUri: String?,
            imageView: ImageView,
        ) {
            Glide.with(ctx)
                .load(profilePhotoUri)
                .centerCrop()
                .circleCrop()
                .into(imageView)
        }
    }

    fun uploadUser(item: User) {
        Log.d("eilon", item.toString())
        db.collection(USERS_COLLECTION_TAG)
            .document(item.uid)
            .set(item)
    }

    fun loadMainUser(callback: (User) -> Unit) {
        getUserObj(Firebase.auth.currentUser!!.uid,
            { user = it; callback(it) }, { user = User(uid = Firebase.auth.currentUser!!.uid) })
    }

    fun getUserObj(uid: String, successCallback: (User) -> Unit, FailureCallback: () -> Unit) {
        db.collection(USERS_COLLECTION_TAG)
            .document(uid)
            .get()
            .addOnSuccessListener {
                val res = it.toObject(User::class.java)
                if (res != null) {
                    successCallback(res)
                    Log.d("eilon", "sccss")
                } else {
                    FailureCallback()
                    Log.d("eilon", "failsc")
                }
            }
            .addOnFailureListener {
                FailureCallback()
                Log.d("eilon", "fail")
            }
    }
}
