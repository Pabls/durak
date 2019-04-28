package com.ar4i.durak.data.dao

import android.database.Cursor
import com.ar4i.durak.data.DbHelper
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.Exception
import javax.inject.Inject
import com.ar4i.durak.data.tables.GamesTable
import com.ar4i.durak.data.dto.GameDto


class GamesDao : IGamesDao {

    @Inject
    constructor(dbHelper: DbHelper) {
        this.dbHelper = dbHelper
    }

    //==========================================start Fields============================================================

    var dbHelper: DbHelper

    //-------------------------------------------end Fields-------------------------------------------------------------


    //==========================================start Implements IGamesDao==============================================

    override fun getGames(): Single<List<GameDto>> {
        return Single.create { emitter ->

            var gamesDaoList: MutableList<GameDto> = ArrayList()
            var cursor: Cursor? = null
            try {
                val db = this.dbHelper.writableDatabase
                cursor = db.rawQuery(GamesTable.getTableCreationCommand(), null)
                if (cursor.moveToFirst()) {
                    while (!cursor.isAfterLast) {
                        val date = cursor.getString(cursor.getColumnIndex(GamesTable.getDateFieldName()))
                        val isWin = cursor.getInt(cursor.getColumnIndex(GamesTable.getIsWinFieldName())) > 0
                        val time = cursor.getLong(cursor.getColumnIndex(GamesTable.getTimeFieldName()))
                        val playersNumber =
                            cursor.getInt(cursor.getColumnIndex(GamesTable.getPlayersNumberFieldName()))

                        gamesDaoList.add(
                            GameDto(
                                date = date,
                                isWin = isWin,
                                gameTime = time,
                                playersNumber = playersNumber
                            )
                        )
                        cursor.moveToNext()
                    }
                }
            } catch (ex: Exception) {
                closeConnection(cursor)
                emitter.onError(ex)
            } finally {
                closeConnection(cursor)
                emitter.onSuccess(gamesDaoList)
            }

        }
    }

    override fun insertGame(gameDto: GameDto): Completable {
        return Completable.create { emitter ->
            try {
                val db = this.dbHelper.writableDatabase
                var contentValue =
                    GamesTable.toContentValues(gameDto.date, gameDto.isWin, gameDto.gameTime, gameDto.playersNumber)

                db.insert(GamesTable.getTableName(), null, contentValue)
            } catch (ex: Exception) {
                dbHelper.close()
                emitter.onError(ex)
            } finally {
                dbHelper.close()
                emitter.onComplete()
            }
        }
    }


    //-------------------------------------------end Implements IGamesDao-----------------------------------------------


    //==========================================start Private methods===================================================

    private fun closeConnection(cursor: Cursor?) {
        if (cursor != null && cursor.isClosed) {
            cursor.close()
        }
        dbHelper.close()
    }

    //-------------------------------------------end Private methods----------------------------------------------------

}