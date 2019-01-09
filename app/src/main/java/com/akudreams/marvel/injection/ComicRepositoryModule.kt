package com.akudreams.marvel.injection

import com.akudreams.marvel.ComicApi
import com.akudreams.marvel.data.ComicDao
import com.akudreams.marvel.data.ComicRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ComicRepositoryModule {
    @Provides
    @Singleton
    fun provideComicRepository(api: ComicApi, comicDao: ComicDao): ComicRepository {
        return ComicRepository(api, comicDao)
    }
}