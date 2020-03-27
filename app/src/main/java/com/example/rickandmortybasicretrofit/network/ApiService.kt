package com.example.rickandmortybasicretrofit.network

import com.example.rickandmortybasicretrofit.network.response.CharactersResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


val logging = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val httpClient = OkHttpClient.Builder()
    .readTimeout(10, TimeUnit.SECONDS)
    .connectTimeout(5, TimeUnit.SECONDS)
    .addInterceptor(logging)
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://rickandmortyapi.com/api/")
    .client(httpClient)
    .build()

object RMApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}

interface ApiService{

    @GET("character/")
    fun getCharactersList() : Call<CharactersResponse>

    @GET("location/")
    fun getLocations() : Call<Any>
}

