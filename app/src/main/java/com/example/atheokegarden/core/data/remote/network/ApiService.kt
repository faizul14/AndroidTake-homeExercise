package com.example.atheokegarden.core.data.remote.network

import com.example.atheokegarden.core.data.remote.response.ResponseSuhu
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("current.json")
    fun getSuhu(
        @Query("key") key: String,
        @Query("q") q: String
    ) : Call<ResponseSuhu>
}