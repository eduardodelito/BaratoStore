package com.enaz.baratostore.common.manager

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

/**
 * Created by eduardo.delito on 5/7/20.
 */
interface FirebaseAuthenticationManager {
    fun register(email: String, password: String, userName: String, onResult: (Boolean) -> Unit)

    fun login(email: String, password: String, onResult: (Boolean) -> Unit)

    fun getUserId(): String

    fun signOut()

    fun isUserLogged(): Boolean

    fun getDisplayName(): String

    fun getEmail(): String

    fun getMobileNumber(): String
}

class FirebaseAuthenticationManagerImpl(private val firebaseAuth: FirebaseAuth) : FirebaseAuthenticationManager {

    override fun register(
        email: String,
        password: String,
        userName: String,
        onResult: (Boolean) -> Unit
    ) {
       firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
           if (it.isComplete && it.isSuccessful) {
               firebaseAuth.currentUser?.updateProfile(
                   UserProfileChangeRequest
                   .Builder()
                   .setDisplayName(userName)
                   .build())
               //3
               onResult(true)
           } else {
               onResult(false)
           }
       }
    }

    override fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            onResult(it.isComplete && it.isSuccessful)
        }
    }

    override fun getUserId(): String = firebaseAuth.currentUser?.uid ?: ""

    override fun signOut() {
        firebaseAuth.signOut()
    }

    override fun isUserLogged() = firebaseAuth.currentUser != null

    override fun getDisplayName() = firebaseAuth.currentUser?.displayName.toString()

    override fun getEmail() = firebaseAuth.currentUser?.email.toString()

    override fun getMobileNumber() = firebaseAuth.currentUser?.phoneNumber.toString()
}
