package com.example.fluffy_aos.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

object DbManager {

    private const val DATABASE_NAME = "fluffy_database"
    private const val DATABASE_VERSION = 1

    private const val CREATE_PET_TABLE_QUERY = "CREATE TABLE if not exists pet (" +
            "_id integer primary key autoincrement," +
            "name text," +
            "species text," +
            "breed_group text," +
            "breed text," +
            "furType text," +
            "age integer," +
            "sex text);"

    private const val DROP_TABLE_QUERY = "DROP TABLE if exists pet"

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

    private class DbHelper(
        context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int
    ) : SQLiteOpenHelper(context, name, factory, version) {

        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(DbManager.CREATE_PET_TABLE_QUERY)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL(DbManager.DROP_TABLE_QUERY)
            onCreate(db)
        }
    }

}
