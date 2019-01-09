package com.akudreams.marvel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.akudreams.marvel.data.Comic
import com.akudreams.marvel.data.ComicRepository
import javax.inject.Inject

class ComicsViewModel: ViewModel() {
    var comics: LiveData<List<Comic>>? = null
    var comicRepository: ComicRepository? = null

    @Inject fun init(repository: ComicRepository) {
        comicRepository = repository
    }

    fun loadComics() {
        comics = comicRepository?.getComics()
    }

}