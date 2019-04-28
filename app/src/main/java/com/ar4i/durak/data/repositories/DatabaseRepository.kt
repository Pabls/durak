package com.ar4i.durak.data.repositories

import com.ar4i.durak.data.db.dao.IGamesDao
import com.ar4i.durak.data.mappers.IGamesMapper
import com.ar4i.durak.data.viewmodels.GameVm
import io.reactivex.Completable
import io.reactivex.Single

class DatabaseRepository : IDatabaseRepository {

    constructor(gamesDao: IGamesDao, gamesMapper: IGamesMapper) {
        this.gamesDao = gamesDao
        this.gamesMapper = gamesMapper
    }

    //==========================================start Fields============================================================

    private var gamesDao: IGamesDao
    private var gamesMapper: IGamesMapper

    //-------------------------------------------end Fields-------------------------------------------------------------


    //==========================================start implements IDatabaseRepository====================================
    override fun getGames(): Single<List<GameVm>> {
        return gamesDao.getGames().map { gameDtos -> gamesMapper.toVms(gameDtos) }
    }

    override fun insertGame(gameVm: GameVm): Completable {
        var gameDto = gamesMapper.toDto(gameVm)
        return gamesDao.insertGame(gameDto)
    }

    //-------------------------------------------end implements IDatabaseRepository-------------------------------------
}