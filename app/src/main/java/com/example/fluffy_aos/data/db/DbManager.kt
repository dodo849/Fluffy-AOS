package com.example.fluffy_aos.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

object DbManager {

    private const val DATABASE_NAME = "fluffy_database"
    private const val DATABASE_VERSION = 2

    private const val CREATE_PET_TABLE_QUERY = "CREATE TABLE if not exists pet (" +
            "_id integer primary key autoincrement," +
            "name text," +
            "species text," +
            "breed text," +
            "furType text," +
            "age integer," +
            "sex text);"

    private const val CREATE_BCS_TABLE_QUERY = "CREATE TABLE if not exists bcs (" +
            "_id integer primary key autoincrement," +
            "pet_id integer," +
            "date text," +
            "field_name text," +
            "value text" +
            ");"

    private const val DROP_PET_TABLE_QUERY = "DROP TABLE IF EXISTS pet"
    private const val DROP_BCS_TABLE_QUERY = "DROP TABLE IF EXISTS bcs"

    private var dbHelper: DbHelper? = null

    fun init(context: Context) {
        dbHelper = DbHelper(context, DATABASE_NAME, null, DATABASE_VERSION)
    }

    fun getWritableDatabase(): SQLiteDatabase {
        return dbHelper!!.writableDatabase
    }

    fun getReadableDatabase(): SQLiteDatabase {
        return dbHelper!!.readableDatabase
    }

    fun closeDatabase() {
        dbHelper?.close()
    }

    fun resetDatabase() {
        val db = dbHelper?.writableDatabase
        db?.execSQL(DROP_PET_TABLE_QUERY)
        db?.execSQL(DROP_BCS_TABLE_QUERY)
    }

    private class DbHelper(
        context: Context?, name: String?,
        factory: SQLiteDatabase.CursorFactory?,
        version: Int
    ) : SQLiteOpenHelper(context, name, factory, version) {

        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(CREATE_PET_TABLE_QUERY)
            db.execSQL(CREATE_BCS_TABLE_QUERY)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db?.execSQL(DROP_PET_TABLE_QUERY)
            db?.execSQL(DROP_BCS_TABLE_QUERY)
            onCreate(db)
        }
    }

}
