package br.com.mobile.thedictionary.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class ApiModule {
    val BASE_URL = "https://api.dictionaryapi.dev/"

     fun clinet(): OkHttpClient =
         OkHttpClient.Builder()
             .connectTimeout(10, TimeUnit.SECONDS)
             .readTimeout(10, TimeUnit.SECONDS)
             .addInterceptor(HttpLoggingInterceptor().apply {
                 level = HttpLoggingInterceptor.Level.BODY
             })
             .build()

    fun gson(): Gson = GsonBuilder().create()

    fun retrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clinet())
            .addConverterFactory(GsonConverterFactory.create(gson()))
            .build()

    fun services(): ApiService =
        retrofit().create(ApiService::class.java)
}