package jey.co.`in`.kotlin.first.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonObject

@Entity  (tableName = "users")
data class Users(
    @PrimaryKey val id: String,
    val name: String,
    val username: String,
    val email: String,
    val address: JsonObject,
    val phone: String,
    val website: String,
    val company: JsonObject
) {
}

data class Company(val name: String, val catchPhrase: String, val bs: String) {}

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: JsonObject
)