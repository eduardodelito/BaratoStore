package com.enaz.baratostore.profile

import android.graphics.Bitmap
import com.enaz.baratostore.common.viewmodel.BaseViewModel
import com.enaz.firebase.repository.ProfileRepository
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val profileRepository: ProfileRepository) :
    BaseViewModel() {

    fun signOut() = profileRepository.signOut()

    fun getCurrentUser() = profileRepository.getCurrentUser()

    fun uploadImageAndSaveUri(imageBitmap: Bitmap) =
        profileRepository.uploadImageAndSaveUri(imageBitmap)

    fun imageUri() = profileRepository.imageUri

    fun loadProfilePhoto() = profileRepository.loadProfilePhoto()
}
