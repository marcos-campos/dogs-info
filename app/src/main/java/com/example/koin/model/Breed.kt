package com.example.koin.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Breed (
    val weight: Metric,
    val height: Metric,
    val id: Int,
    val name: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("bred_for")
    val bredFor: String,
    @SerializedName("breed_group")
    val breedGroup: String,
    @SerializedName("life_span")
    val lifeSpan: String,
    val temperament: String,
    val origin: String,
    @SerializedName("reference_image_id")
    val referenceImageId: String
    ): Serializable