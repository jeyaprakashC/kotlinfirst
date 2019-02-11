package jey.co.`in`.kotlin.first.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "photos")
data class Photos(
    @PrimaryKey val id: String, val albumId: String,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) {
}