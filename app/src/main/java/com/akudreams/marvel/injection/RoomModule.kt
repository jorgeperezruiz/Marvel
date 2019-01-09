package com.akudreams.marvel.injection

import android.arch.persistence.room.Room
import android.content.Context
import com.akudreams.marvel.data.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class RoomModule {

    @Provides
    @Inject
    fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "app-db").build()

    @Provides
    fun providesComicDao(database: AppDatabase) = database.comicDao()
}