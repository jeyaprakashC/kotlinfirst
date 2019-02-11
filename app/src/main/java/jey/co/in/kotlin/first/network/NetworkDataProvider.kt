package jey.co.`in`.kotlin.first.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkDataProvider {

    lateinit var retrofit: Retrofit

    fun getPlaceHolderClient(): Retrofit {


        val client = OkHttpClient.Builder().build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit
    }

}