package com.enaz.firebase.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

/**
 * Created by eduardo.delito on 5/11/20.
 */
interface AuthenticationRepository {

    fun register(email: String, password: String, userName: String, onResult: (Boolean) -> Unit)

    fun login(email: String, password: String, onResult: (Boolean) -> Unit)

    fun isUserLogged() : Boolean
}

class AuthenticationRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
) :
    AuthenticationRepository {

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
                        .build()
                )
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

    override fun isUserLogged() = firebaseAuth.currentUser != null
}
