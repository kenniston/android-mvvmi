package br.com.dynamiclight.androidmvvmi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.dynamiclight.androidmvvmi.AppResult
import br.com.dynamiclight.androidmvvmi.domain.Movie
import br.com.dynamiclight.androidmvvmi.interactor.MovieInteractor
import br.com.dynamiclight.androidmvvmi.repository.dto.network.MovieQueryOrderBy
import io.reactivex.disposables.Disposable

class MainViewModel(val app: Application) : AndroidViewModel(app) {
    private val interactor = MovieInteractor(app.applicationContext)

    private var disposable: Disposable? = null

    val lastMovies = MutableLiveData<AppResult<Array<Movie>>>()

    fun getLastMovies() {

        disposable = interactor.lastMovies(MovieQueryOrderBy.PopularityAsc()).subscribe { res, error ->
            if (error != null) {
                lastMovies.value = AppResult.Error(error)
                return@subscribe
            }

            lastMovies.value = AppResult.Success(res)
        }

    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}
