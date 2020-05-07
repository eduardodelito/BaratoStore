package com.enaz.baratostore.profile

import android.graphics.Bitmap
import com.enaz.baratostore.common.manager.FirebaseAuthenticationManager
import com.enaz.baratostore.common.manager.FirebaseStoreManager
import com.enaz.baratostore.common.viewmodel.BaseViewModel
import javax.inject.Inject

class ProfileViewModel@Inject constructor(private val firebaseAuthenticationManager: FirebaseAuthenticationManager,
private val firebaseStoreManager: FirebaseStoreManager
) : BaseViewModel() {

    fun signOut() {
        firebaseAuthenticationManager.signOut()
    }

    fun getDisplayName() = firebaseAuthenticationManager.getDisplayName()

    fun getEmail() = firebaseAuthenticationManager.getEmail()

    fun getMobileNumber() = firebaseAuthenticationManager.getMobileNumber()

    fun uploadImageAndSaveUri(imageBitmap: Bitmap) = firebaseStoreManager.uploadImageAndSaveUri(imageBitmap)

    fun isUploading() = firebaseStoreManager.isUploading

    fun imageUri() = firebaseStoreManager.imageUri
}
