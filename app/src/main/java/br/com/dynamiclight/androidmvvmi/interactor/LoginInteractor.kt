package br.com.dynamiclight.androidmvvmi.interactor

import android.content.Context
import br.com.dynamiclight.androidmvvmi.repository.LoginRepository

class LoginInteractor(context: Context) {

    private val loginRepository = LoginRepository(context)

    fun login(email: String, password: String): String {

        //TODO: Validate email and password

        return loginRepository.login(email, password)
    }

}