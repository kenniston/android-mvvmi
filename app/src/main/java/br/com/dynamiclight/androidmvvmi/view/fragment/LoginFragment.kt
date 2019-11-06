package br.com.dynamiclight.androidmvvmi.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import br.com.dynamiclight.androidmvvmi.databinding.FragmentLoginBinding
import br.com.dynamiclight.androidmvvmi.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this@LoginFragment).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this


        return binding.root
    }

    fun forgot() {
        //TODO: Navigation to forgot password fragment

    }

}
