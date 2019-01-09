package com.akudreams.marvel

import com.akudreams.marvel.data.ComicsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicApi {
    @GET("v1/public/comics")
    fun getComics(@Query("limit") limit: Int): Call<ComicsResponse>
}