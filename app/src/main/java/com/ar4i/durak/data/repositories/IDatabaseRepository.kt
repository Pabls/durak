package com.ar4i.durak.data.repositories

import com.ar4i.durak.data.viewmodels.GameVm
import io.reactivex.Completable
import io.reactivex.Single

interface IDatabaseRepository {
    fun getGames(): Single<List<GameVm>>
    fun insertGame(gameVm: GameVm): Completable
}