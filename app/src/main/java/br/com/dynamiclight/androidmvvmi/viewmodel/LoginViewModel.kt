package br.com.dynamiclight.androidmvvmi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.dynamiclight.androidmvvmi.AppResult
import br.com.dynamiclight.androidmvvmi.domain.User
import br.com.dynamiclight.androidmvvmi.interactor.LoginInteractor

class LoginViewModel(val app: Application) : AndroidViewModel(app) {
    private val interactor = LoginInteractor(app.applicationContext)

    val password = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val result = MutableLiveData<AppResult<User>>()

    fun login() {
        //TODO: VALIDATE (NULL) EMAIL AND PASSWORD

        interactor.login(email.value!!, password.value!!) {
            result.value = it
        }

    }
}
