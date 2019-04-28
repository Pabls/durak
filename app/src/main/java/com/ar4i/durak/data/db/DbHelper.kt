package com.ar4i.durak.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.ar4i.durak.data.db.tables.GamesTable

class DbHelper(context: Context, version: Int) : SQLiteOpenHelper(context,
    DATABASE_NAME, null, version) {

    companion object {
        const val DATABASE_NAME = "com.ar4i.durak.data.Durak.database"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            db?.beginTransaction()
            db?.execSQL(GamesTable.getTableCreationCommand())

            db?.setTransactionSuccessful()
        } finally {
            db?.endTransaction()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}