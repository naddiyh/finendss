package com.unos.finends.data.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth


class LoginViewModel : ViewModel() {
    var loginData by mutableStateOf(LoginData())
    var isLoading by mutableStateOf(false)
    var authState by mutableStateOf<AuthState>(AuthState.Unauthenticated)

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    fun updateAuthState(newState: AuthState) {
        authState = newState
    }
    // Method untuk update email
    fun onEmailChanged(newEmail: String) {
        loginData = loginData.copy(email = newEmail)
    }

    // Method untuk update password
    fun onPasswordChanged(newPassword: String) {
        loginData = loginData.copy(password = newPassword)
    }

    // Fungsi login
    fun login() {
        isLoading = true
        val email = loginData.email
        val password = loginData.password

        // Cek jika email atau password kosong
        if (email.isEmpty() || password.isEmpty()) {
            updateAuthState(AuthState.Error("Email or password cannot be empty"))
            isLoading = false
            return
        }

        // Lakukan login dengan Firebase
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                isLoading = false
                if (task.isSuccessful) {
                    updateAuthState(AuthState.Authenticated)
                } else {
                    updateAuthState(AuthState.Error(task.exception?.message ?: "Something went wrong"))
                }
            }
    }


}
