package com.example.koin.network

import com.example.koin.model.BreedsResponse
import retrofit2.http.GET

interface EndPoints {

    @GET("search")
    suspend fun getBreeds(): List<BreedsResponse>
}