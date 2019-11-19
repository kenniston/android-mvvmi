package br.com.dynamiclight.androidmvvmi.view.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import br.com.dynamiclight.androidmvvmi.AppResult
import br.com.dynamiclight.androidmvvmi.R
import br.com.dynamiclight.androidmvvmi.databinding.FragmentMainBinding
import br.com.dynamiclight.androidmvvmi.domain.Movie
import br.com.dynamiclight.androidmvvmi.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this@MainFragment).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.lastMovies.observe(this) {
            updateLastMovies(it)
        }

        viewModel.getLastMovies()

        return binding.root
    }

    private fun updateLastMovies(result: AppResult<Array<Movie>>) {
        when (result) {
            is AppResult.Success -> {
                // TODO: UPDATE LAST MOVIES LIST

                result.data.forEach { movie ->
                    Log.d("MOVIES", movie.toString())
                }

            }
            is AppResult.Error -> {
                if (result.error != null) {
                    Toast.makeText(
                        this.context,
                        result.error.localizedMessage,
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

}
