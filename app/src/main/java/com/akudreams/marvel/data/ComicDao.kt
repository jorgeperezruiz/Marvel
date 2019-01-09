package com.akudreams.marvel.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface ComicDao {

    @Query("SELECT * from comic where id = :comicId")
    fun getComic(comicId: Int): LiveData<Comic>

    @Query("SELECT * from comic LIMIT 100")
    fun getComics(): LiveData<List<Comic>>

    @Insert(onConflict = REPLACE)
    fun insert(comics: List<Comic>)

}