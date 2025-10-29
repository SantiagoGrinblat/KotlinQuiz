package com.santidev.kotlinquiz.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch


class LoginViewModel: ViewModel() {
  private val auth: FirebaseAuth = Firebase.auth
//  private fun _loading = MutableLiveData(false)
  
  fun signInWhitGoogleCredential(credential: AuthCredential, user:() -> Unit)
  = viewModelScope.launch {
    try {
      auth.signInWithCredential(credential).addOnCompleteListener { task ->
        if (task.isSuccessful) {
          Log.d("KotlinQuizLogin", "Login Success With Google")
          user()
        }
      }
        .addOnFailureListener {
          Log.d("KotlinQuizLogin", "Login Failed With Google")
        }
    } catch (e: Exception) {
      Log.d("KotlinQuizLogin", "Login Failed With Google:" + e.localizedMessage)
    }
  }
}