package com.example.koin.repository

import com.example.koin.model.BreedsResponse
import com.example.koin.network.EndPoints
import com.example.koin.network.RetrofitInit

class RepositoryApi {

    companion object{
        const val chave = "e8ead66b-b142-486d-ad4c-2f746bef5dad"
    }

    private var url = "https://api.thedogapi.com/v1/images/"
    private var service = EndPoints::class
    private val conectionService = RetrofitInit(url).create(service)

    suspend fun getDogs(): List<BreedsResponse> = conectionService.getBreeds()
}