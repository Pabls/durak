package com.ar4i.durak.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context, version: Int) : SQLiteOpenHelper(context, DATABASE_NAME, null, version) {

    companion object {
        const val DATABASE_NAME = "Durak.db"
        const val CREATE_GAMES_TABLE = "CREATE TABLE ${GamesTable.NAME} (" +
                " ${GamesTable.DATE} TEXT NOT NULL, " +
                " ${GamesTable.GAME_TIME} INTEGER NOT NULL," +
                " ${GamesTable.IS_WIN} BOOLEAN NOT NULL" +
                " )"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_GAMES_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("")
    }
}