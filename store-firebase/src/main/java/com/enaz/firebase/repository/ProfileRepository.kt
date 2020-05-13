package com.enaz.firebase.repository

import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.enaz.firebase.model.Profile
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream

/**
 * Created by eduardo.delito on 5/11/20.
 */
interface ProfileRepository {
    val imageUri: LiveData<Uri?>

    fun getCurrentUser(): FirebaseUser?

    fun loadProfilePhoto()

    fun uploadImageAndSaveUri(imageBitmap: Bitmap)

    fun isUserLogged(): Boolean

    fun signOut()
}

class ProfileRepositoryImpl(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseStorage: FirebaseStorage
) : ProfileRepository {

    private val _imageUri = MutableLiveData<Uri?>()
    override val imageUri: LiveData<Uri?> get() = _imageUri

    override fun uploadImageAndSaveUri(imageBitmap: Bitmap) {
        if (isUserLogged()) {
            val baos = ByteArrayOutputStream()
            val storageRef = firebaseStorage
                .reference
                .child("profile_pic/{${firebaseAuth.currentUser?.uid}}")
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val image = baos.toByteArray()
            val upload = storageRef.putBytes(image)
            upload.addOnCompleteListener { uploadTask ->
                if (uploadTask.isSuccessful && uploadTask.isComplete) {
                    storageRef.downloadUrl.addOnCompleteListener { urlTask ->
                        urlTask.result.let {
                            _imageUri.postValue(it)
                        }
                    }
                } else {
                    uploadTask.exception?.let {
                        _imageUri.postValue(null)
                    }
                }
            }
        }
    }

    override fun loadProfilePhoto() {
        if (isUserLogged()) {
            val storageRef = firebaseStorage
                .reference
                .child("profile_pic/{${firebaseAuth.currentUser?.uid}}")
            storageRef.downloadUrl.addOnCompleteListener {
                if (it.isSuccessful && it.isComplete) {
                    _imageUri.postValue(it.result)
                } else {
                    _imageUri.postValue(null)
                }
            }
        } else {
            _imageUri.postValue(null)
        }
    }

    override fun getCurrentUser() = firebaseAuth.currentUser

    override fun isUserLogged() = firebaseAuth.currentUser != null

    override fun signOut() {
        firebaseAuth.signOut()
    }
}
