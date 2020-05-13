//package com.enaz.baratostore.common.manager
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.enaz.baratostore.model.Profile
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.UserProfileChangeRequest
//
///**
// * Created by eduardo.delito on 5/7/20.
// */
//interface FirebaseAuthenticationManager {
//    fun register(email: String, password: String, userName: String, onResult: (Boolean) -> Unit)
//
//    fun login(email: String, password: String, onResult: (Boolean) -> Unit)
//
//    fun getUserId(): String
//
//    fun signOut()
//
//    fun isUserLogged(): Boolean
//
//    val profile: LiveData<Profile?>
//}
//
//class FirebaseAuthenticationManagerImpl(private val firebaseAuth: FirebaseAuth) :
//    FirebaseAuthenticationManager {
//
//    private val _profile = MutableLiveData<Profile?>()
//    override val profile: LiveData<Profile?> get() = _profile
//
//    override fun register(
//        email: String,
//        password: String,
//        userName: String,
//        onResult: (Boolean) -> Unit
//    ) {
//        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
//            if (it.isComplete && it.isSuccessful) {
//                firebaseAuth.currentUser?.updateProfile(
//                    UserProfileChangeRequest
//                        .Builder()
//                        .setDisplayName(userName)
//                        .build()
//                )
//                //3
//                onResult(true)
//            } else {
//                onResult(false)
//            }
//        }
//    }
//
//    override fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
//        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
//            val userProfile = firebaseAuth.currentUser
//            if (it.isComplete && it.isSuccessful) {
//                _profile.postValue(Profile(userProfile?.displayName, userProfile?.email, userProfile?.phoneNumber))
//                onResult(true)
//            } else {
//                _profile.postValue(null)
//                onResult(false)
//            }
//        }
//    }
//
//    override fun getUserId(): String = firebaseAuth.currentUser?.uid ?: ""
//
//    override fun signOut() {
//        firebaseAuth.signOut()
//    }
//
//    override fun isUserLogged() = firebaseAuth.currentUser != null
//}
