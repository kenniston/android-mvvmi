package br.com.dynamiclight.androidmvvmi.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import br.com.dynamiclight.androidmvvmi.AppResult
import br.com.dynamiclight.androidmvvmi.R
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

        viewModel.result.observe(this@LoginFragment) {
            when (it) {
                is AppResult.Success -> {
                    Toast.makeText(this.context,
                        it.data.id,
                        Toast.LENGTH_LONG).show()

                        findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
                        activity?.finish()
                }
                is AppResult.Error -> {
                    if (it.error != null) {
                        Toast.makeText(
                            this.context,
                            it.error.localizedMessage,
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        val genericError = this.context?.getString(R.string.generic_error)
                        Toast.makeText(
                            this.context,
                            genericError,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }


        return binding.root
    }

    fun forgot() {
        //TODO: Navigation to forgot password fragment
        findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
    }

}
