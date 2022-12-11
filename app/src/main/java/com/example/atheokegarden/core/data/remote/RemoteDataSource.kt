package com.example.atheokegarden.core.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.atheokegarden.core.data.remote.network.ApiService
import com.example.atheokegarden.core.data.remote.response.ResponseSuhu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    companion object {
        const val TAG = "RemoteDataSource"
    }

    fun getSuhu(key: String, country: String): LiveData<ResponseSuhu> {
        var data = MutableLiveData<ResponseSuhu>()
        val client = apiService.getSuhu(key, country)
        client.enqueue(object : Callback<ResponseSuhu> {
            override fun onResponse(call: Call<ResponseSuhu>, response: Response<ResponseSuhu>) {
                val responseBosy = response.body()
                if (response.isSuccessful && responseBosy != null) {
                    data.value = responseBosy!!
                } else {
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<ResponseSuhu>, t: Throwable) {
                Log.d(TAG, t.message.toString())

            }

        })
        return data
    }
}