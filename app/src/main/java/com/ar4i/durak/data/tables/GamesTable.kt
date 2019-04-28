package com.ar4i.durak.data.tables

import android.content.ContentValues

class GamesTable {

    companion object {
        private const val NAME = "games"
        private const val DATE = "date"
        private const val IS_WIN = "is_win"
        private const val GAME_TIME = "time"
        private const val PLAYERS_NUMBER = "players_number"
        private const val CREATE_TABLE = "CREATE TABLE $NAME (" +
                " $DATE TEXT NOT NULL, " +
                " $GAME_TIME INTEGER NOT NULL," +
                " $IS_WIN BOOLEAN NOT NULL" +
                " $PLAYERS_NUMBER INTEGER NOT NULL" +
                " )"

        fun getTableName(): String {
            return NAME
        }

        fun getDateFieldName(): String {
            return DATE
        }

        fun getIsWinFieldName(): String {
            return IS_WIN
        }

        fun getTimeFieldName(): String {
            return GAME_TIME
        }

        fun getPlayersNumberFieldName(): String {
            return PLAYERS_NUMBER
        }

        fun getTableCreationCommand(): String {
            return CREATE_TABLE
        }

        fun toContentValues(date: String, isWin: Boolean, gameTime: Long, playersNumber: Int): ContentValues {
            var cv: ContentValues = ContentValues()
            cv.put(DATE, date)
            cv.put(IS_WIN, isWin)
            cv.put(GAME_TIME, gameTime)
            cv.put(PLAYERS_NUMBER, playersNumber)
            return cv
        }
    }

    //==========================================start Public methods==============================================


    //-------------------------------------------end Public methods-----------------------------------------------
}