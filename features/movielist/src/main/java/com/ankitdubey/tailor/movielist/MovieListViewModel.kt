package com.ankitdubey.tailor.movielist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitdubey.tailor.core.model.Genre
import com.ankitdubey.tailor.core.model.Movie
import com.ankitdubey.tailor.core.repository.GenreRepository
import com.ankitdubey.tailor.core.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Ankit Dubey on 18,July,2021
 */

@HiltViewModel
class MovieListViewModel
@Inject
constructor(
    private val movieRepository: MovieRepository,
    private val genreRepository: GenreRepository
) : ViewModel() {

    private val _movieLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
    val movieLiveData: LiveData<List<Movie>> = _movieLiveData

    private val _categoryList: MutableLiveData<List<String>> = MutableLiveData()
    val categoryList: LiveData<List<String>> = _categoryList

    init {
        fetchMovies()
        fetchGenreList()
    }

    private fun fetchGenreList() {
        genreRepository.genreList().onEach {
            if (it.data != null) {
                parseGenreList(it.data!!)
            }
        }.launchIn(viewModelScope)
    }

    private fun parseGenreList(list: List<Genre>) {
        _categoryList.value =
            list.fold(listOf()) { initialList, genre ->
                initialList + genre.name
            }
    }

    private fun fetchMovies() {
        movieRepository.popularMovies().onEach {
            Log.e("WIg", "...$it")
            if (it.data != null)
                _movieLiveData.postValue(it.data)
        }.launchIn(viewModelScope)
    }

}