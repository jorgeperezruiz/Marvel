package com.akudreams.marvel.data

import android.arch.lifecycle.LiveData
import android.util.Log
import com.akudreams.marvel.ComicApi
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ComicRepository @Inject constructor(val api: ComicApi, val comicDao: ComicDao) {

    fun getComics(): LiveData<List<Comic>> {
        refreshComics()
        return comicDao.getComics()
    }

    fun refreshComics() {
        api.getComics(100).enqueue(object : Callback<ComicsResponse> {
            override fun onResponse(call: Call<ComicsResponse>?, response: Response<ComicsResponse>?) {
                if (response != null && response.isSuccessful) {
                    doAsync{ comicDao.insert(response.body()?.toComics()!!) }
                } else {
                    // TODO
                }
            }

            override fun onFailure(call: Call<ComicsResponse>?, t: Throwable?) {
                // TODO
                Log.e("Error", "Comic Network Error $t")
            }
        })
    }
}