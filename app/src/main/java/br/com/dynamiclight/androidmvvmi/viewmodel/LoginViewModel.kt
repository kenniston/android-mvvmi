package br.com.dynamiclight.androidmvvmi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.dynamiclight.androidmvvmi.interactor.LoginInteractor

class LoginViewModel(val app: Application) : AndroidViewModel(app)  {
    private val interactor = LoginInteractor(app.applicationContext)

    val password = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val result = MutableLiveData<String>()

    fun login() {
        //TODO: VALIDATE (NULL) EMAIL AND PASSWORD

        result.value = interactor.login(email.value!!, password.value!!)

    }
}
