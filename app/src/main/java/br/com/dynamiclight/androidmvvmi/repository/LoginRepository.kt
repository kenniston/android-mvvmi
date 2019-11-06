package br.com.dynamiclight.androidmvvmi.repository

import android.content.Context

class LoginRepository(val context: Context) {

    fun login(email: String, password: String): String {
        return "Sucesso"
    }

}