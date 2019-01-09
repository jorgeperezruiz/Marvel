package com.akudreams.marvel.injection

import android.content.Context
import com.akudreams.marvel.data.ComicRepository
import com.akudreams.marvel.ComicsViewModel
import com.akudreams.marvel.MarvelApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, RoomModule::class, RetrofitModule::class, ComicRepositoryModule::class, ApiModule::class))
interface AppComponent {
    fun inject(viewModelModule: ComicsViewModel)
    fun inject(activity: Context)

    fun provideComicRepository(): ComicRepository

    companion object Factory{
        fun create(app: MarvelApplication): AppComponent {
            val appComponent = DaggerAppComponent.builder().
                    appModule(AppModule(app)).
                    roomModule(RoomModule()).
                    retrofitModule(RetrofitModule()).
                    apiModule(ApiModule()).
                    comicRepositoryModule(ComicRepositoryModule()).build()
            return appComponent
        }
    }
}