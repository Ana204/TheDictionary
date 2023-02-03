package br.com.mobile.thedictionary.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface ApiService {

    @GET("api/v2/entries/en/hello/")
    fun getWord() : Call<JsonArray>
}