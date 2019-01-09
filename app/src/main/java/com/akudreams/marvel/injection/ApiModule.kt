package com.akudreams.marvel.injection

import com.akudreams.marvel.ComicApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ComicApi {
        return retrofit.create<ComicApi>(ComicApi::class.java)
    }
}