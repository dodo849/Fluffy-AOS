package com.example.fluffy_aos.model.pet

data class Pet(
    val id: Long = 0L,
    val name: String,
    val species: String,
    val breedGroup: String,
    val breed: String,
    val furType: String,
    val age: Int,
    val sex: String
)