package com.enaz.baratostore.common.manager

import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream

/**
 * Created by eduardo.delito on 5/7/20.
 */
interface FirebaseStoreManager {
    val isUploading: LiveData<Boolean>

    val imageUri: LiveData<Uri>

    fun uploadImageAndSaveUri(imageBitmap: Bitmap)
}

class FirebaseStoreManagerImpl(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseStorage: FirebaseStorage
) : FirebaseStoreManager {

    private val _isUploading = MutableLiveData<Boolean>(false)
    override val isUploading: LiveData<Boolean> get() = _isUploading

    private val _imageUri = MutableLiveData<Uri>()
    override val imageUri: LiveData<Uri> get() = _imageUri

    override fun uploadImageAndSaveUri(imageBitmap: Bitmap) {
        _isUploading.postValue(true)
        val baos = ByteArrayOutputStream()
        val storageRef = firebaseStorage
            .reference
            .child("profile_pic/{${firebaseAuth.currentUser?.uid}}")
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val image = baos.toByteArray()
        val upload = storageRef.putBytes(image)
        upload.addOnCompleteListener {uploadTask ->
            if (uploadTask.isSuccessful && uploadTask.isComplete) {
                storageRef.downloadUrl.addOnCompleteListener { urlTask ->
                    urlTask.result.let {
                        _isUploading.postValue(false)
                        _imageUri.postValue(it)
                    }
                }
            } else {
                uploadTask.exception?.let {
                    _isUploading.postValue(false)
                    _imageUri.postValue(null)
                }
            }
        }
    }
}
