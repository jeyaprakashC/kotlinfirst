package jey.co.`in`.kotlin.first.storage

import androidx.room.TypeConverter
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.util.*





class JsonConverter {

    @TypeConverter
    fun toJson(value: String): JsonObject {

        val gson = GsonBuilder().create()

        val element = gson.fromJson(value, JsonElement::class.java)
        val jsonObj = element.getAsJsonObject()

        return jsonObj
    }


    @TypeConverter
    fun fromJson(value: JsonObject): String {
        return value.toString()
    }

    @TypeConverter
    fun toDate(dateLong: Long): Date {
        return Date(dateLong)
    }


    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }
}