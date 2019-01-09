package com.akudreams.marvel.data

import com.google.gson.annotations.SerializedName

data class ComicsResponse (@SerializedName("data") val data: ComicsData) {
    fun toComics() : List<Comic> {
        return data.comics.map { Comic(it.id, it.title, "${it.thumbnail.path}.${it.thumbnail.extension}") } // TODO Create url in a different class with unit tests
    }
}

data class ComicsData (@SerializedName("results") val comics: List<ComicResponse> = ArrayList())
data class ComicResponse (var id: Int, var title: String, var thumbnail: ThumbnailResponse)
data class ThumbnailResponse (var path: String, var extension: String)