package com.example.filmlerapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.filmlerapp.data.datasource.FilmlerDataSource
import com.example.filmlerapp.data.entity.Filmler


class FilmlerRepository(var fds : FilmlerDataSource) {
    fun filmleriYukle() : MutableLiveData<List<Filmler>> = fds.filmleriYukle()
}