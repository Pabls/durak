package com.ar4i.durak.domain

import com.ar4i.durak.data.repositories.DatabaseRepository
import com.ar4i.durak.data.viewmodels.GameVm
import io.reactivex.Completable
import io.reactivex.Single

class GameInteractor : IGameInteractor {

    constructor(databaseRepository: DatabaseRepository) {
        this.databaseRepository = databaseRepository
    }

    //==========================================start Fields============================================================

    private var databaseRepository: DatabaseRepository

    //-------------------------------------------end Fields-------------------------------------------------------------


    override fun insertGame(gameVm: GameVm): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGames(): Single<List<GameVm>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}