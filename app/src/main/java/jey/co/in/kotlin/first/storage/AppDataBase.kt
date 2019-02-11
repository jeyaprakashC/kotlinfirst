package jey.co.`in`.kotlin.first.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import jey.co.`in`.kotlin.first.models.Photos
import jey.co.`in`.kotlin.first.models.Users

@Database(entities = arrayOf(Photos::class, Users::class), version = 2)
@TypeConverters(JsonConverter::class)

abstract class AppDataBase : RoomDatabase() {

    abstract fun getDao(): RoomDao
}