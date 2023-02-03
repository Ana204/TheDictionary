package br.com.mobile.thedictionary.network

import android.util.Log
import com.google.gson.JsonArray
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(private val apiService: ApiService) {

    val TAG = "Remote Data Source"
    fun getWordDetails(request: String){
        apiService.getWord().enqueue(object : Callback<JsonArray> {
            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                if (response.isSuccessful){
                    val message: String = response.body().toString()

                    Log.e(TAG, "onResponse: $message")
                }else{
                    val message: String = response.errorBody().toString()

                    Log.e(TAG, "onResponse: else $message")
                }
            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.e(TAG, "onFailure: $call")
                Log.e(TAG, "onFailure: $t")
            }


        })
    }
}