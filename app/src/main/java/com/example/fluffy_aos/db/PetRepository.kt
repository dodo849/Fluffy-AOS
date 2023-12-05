package com.example.fluffy_aos.db

import android.content.ContentValues
import com.example.fluffy_aos.model.pet.Pet

class PetRepository(private val dbManager: DbManager) {

    fun readAllPets(): List<Pet> {
        val petList = mutableListOf<Pet>()
        val db = dbManager.getWritableDatabase()

        db.use {
            val cursor = it.query(
                "pet",
                null, // null은 모든 열을 의미
                null,
                null,
                null,
                null,
                null
            )

            cursor?.use { cursor ->
                while (cursor.moveToNext()) {
                    val id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"))
                    val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                    val species = cursor.getString(cursor.getColumnIndexOrThrow("species"))
                    val breedGroup = cursor.getString(cursor.getColumnIndexOrThrow("breed_group"))
                    val breed = cursor.getString(cursor.getColumnIndexOrThrow("breed"))
                    val purType = cursor.getString(cursor.getColumnIndexOrThrow("furType"))
                    val age = cursor.getInt(cursor.getColumnIndexOrThrow("age"))
                    val sex = cursor.getString(cursor.getColumnIndexOrThrow("sex"))

                    val pet = Pet(id, name, species, breedGroup, breed, purType, age, sex)
                    println(pet.toString())
                }
            }
        }

        return petList
    }

    fun insertPet(pet: Pet): Long {
        val db = dbManager.getWritableDatabase()

        val values = ContentValues().apply {
            put("name", pet.name)
            put("species", pet.species)
            put("breed_group", pet.breedGroup)
            put("breed", pet.breed)
            put("furType", pet.furType)
            put("age", pet.age)
            put("sex", pet.sex)
        }

        return db.insert("pet", null, values)
    }
}
