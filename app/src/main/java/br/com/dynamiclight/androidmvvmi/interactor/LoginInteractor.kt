package br.com.dynamiclight.androidmvvmi.interactor

import android.content.Context
import br.com.dynamiclight.androidmvvmi.AppResult
import br.com.dynamiclight.androidmvvmi.domain.User
import br.com.dynamiclight.androidmvvmi.repository.LoginRepository

class LoginInteractor(context: Context) {

    private val loginRepository = LoginRepository(context)

    fun login(email: String, password: String, callback: (result: AppResult<User>) -> Unit) {

        //TODO: Validate email and password

        loginRepository.login(email, password, callback)
    }

}