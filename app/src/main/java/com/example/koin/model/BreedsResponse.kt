package com.example.koin.model

import java.io.Serializable

data class BreedsResponse(
    val breeds: List<Breed>,
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
    ): Serializable
