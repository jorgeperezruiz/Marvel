package com.akudreams.marvel.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Comic::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun comicDao(): ComicDao
}