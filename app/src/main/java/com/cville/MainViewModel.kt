package com.cville

import android.content.Context
import android.net.Uri
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
        db.collection(USERS_COLLECTION_TAG)
            .document(item.uid)
            .set(item)
    }

    fun loadMainUser() {
        getUserObj(Firebase.auth.currentUser!!.uid) {
            user = it
        }
    }

    fun getUserObj(uid: String, callback: (User) -> Unit) {
        db.collection(USERS_COLLECTION_TAG)
            .document(uid)
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
}
