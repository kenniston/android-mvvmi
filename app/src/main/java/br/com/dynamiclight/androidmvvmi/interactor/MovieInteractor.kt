package br.com.dynamiclight.androidmvvmi.interactor

import android.content.Context
import br.com.dynamiclight.androidmvvmi.domain.Movie
import br.com.dynamiclight.androidmvvmi.repository.MovieRepository
import br.com.dynamiclight.androidmvvmi.repository.dto.network.MovieQueryOrderBy
import io.reactivex.Single

class MovieInteractor(context: Context) {

    private val movieRepository = MovieRepository(context)

    fun lastMovies(sortBy: MovieQueryOrderBy): Single<Array<Movie>> {
        return movieRepository.lastMovies(sortBy)
    }

}