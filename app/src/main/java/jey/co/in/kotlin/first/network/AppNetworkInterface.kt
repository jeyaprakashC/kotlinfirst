package jey.co.`in`.kotlin.first.network

import jey.co.`in`.kotlin.first.models.Photos
import jey.co.`in`.kotlin.first.models.Users
import retrofit2.Call
import retrofit2.http.GET

interface AppNetworkInterface {

    @GET("/users")
    fun getUsers(): Call<List<Users>>


    @GET("/photos")
    fun getAlbums(): Call<List<Photos>>


}