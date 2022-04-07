package com.cville

import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class MainViewModel : ViewModel() {
    private lateinit var user: User
    private val db = FirebaseFirestore.getInstance()

    companion object {
        private const val USERS_COLLECTION_TAG = "Users"
    }

    fun uploadUser(item: User) {
        val userUid = Firebase.auth.currentUser!!.uid
        db.collection(USERS_COLLECTION_TAG)
            .document(userUid)
            .set(item)
    }

    fun loadMainUser() {
        getUserObj(Firebase.auth.currentUser!!.uid) {
            user = it
        }
    }

    fun getUserObj(uid: String, callback: (User) -> Unit) {
        db.collection(USERS_COLLECTION_TAG)
            .document(Firebase.auth.currentUser!!.uid)
            .get()
            .addOnSuccessListener {
                val res = it.toObject(User::class.java)
                if (res != null) {
                    callback(res)
                }
            }
            .addOnFailureListener {
            }
    }

    fun setProfileImgToView(
        ctx: Context,
        profilePhotoUri: String,
        imageView: ImageView,
    ) {
        Glide.with(ctx)
            .load(profilePhotoUri)
            .centerCrop()
            .circleCrop()
            .into(imageView)
    }
}
