package com.example.fluffy_aos.data.repository

import android.content.ContentValues
import com.example.fluffy_aos.data.db.DbManager
import com.example.fluffy_aos.model.pet.Pet
import com.example.fluffy_aos.model.pet.PetConverter

// Warn: Selection Type save/read 할 때는 Code로
class PetRepository(
    private val dbManager: DbManager = DbManager,
    private val petConverter: PetConverter = PetConverter(),
) {

    fun readPetById(id: Long): Pet? {
        val db = dbManager.getWritableDatabase()
        var pet: Pet? = null

        db.use { database ->
            val cursor = database.query(
                "pet",
                null,
                "_id = ?",
                arrayOf(id.toString()),
                null,
                null,
                null
            )

            cursor?.use { petCursor ->
                if (petCursor.moveToNext()) {
                    val id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"))
                    val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                    val species = cursor.getString(cursor.getColumnIndexOrThrow("species"))
                    val breed = cursor.getString(cursor.getColumnIndexOrThrow("breed"))
                    val furType = cursor.getString(cursor.getColumnIndexOrThrow("furType"))
                    val age = cursor.getInt(cursor.getColumnIndexOrThrow("age"))
                    val sex = cursor.getString(cursor.getColumnIndexOrThrow("sex"))

                    pet = Pet(
                        id,
                        name,
                        species,
                        breed,
                        furType,
                        age,
                        sex
                    )
                }
            }
        }

        return pet
    }

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
                    val breed = cursor.getString(cursor.getColumnIndexOrThrow("breed"))
                    val furType = cursor.getString(cursor.getColumnIndexOrThrow("furType"))
                    val age = cursor.getInt(cursor.getColumnIndexOrThrow("age"))
                    val sex = cursor.getString(cursor.getColumnIndexOrThrow("sex"))

                    val pet = Pet(
                        id,
                        name,
                        species,
                        breed,
                        furType,
                        age,
                        sex
                    )
                    petList.add(pet)
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
            put("breed", pet.breed)
            put("furType", pet.furType)
            put("age", pet.age)
            put("sex", pet.sex)
        }

        return db.insert("pet", null, values)
    }

    fun deletePet(petId: Long): Int {
        val db = dbManager.getWritableDatabase()

        return db.use {
            val whereClause = "_id = ?"
            val whereArgs = arrayOf(petId.toString())

            it.delete("pet", whereClause, whereArgs)
        }
    }
}
