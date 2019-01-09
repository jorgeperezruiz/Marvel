package com.akudreams.marvel.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "comic")
data class Comic (@PrimaryKey var id: Int, var title: String, var thumbnailUrl: String)