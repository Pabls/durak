package com.ar4i.durak.domain

import com.ar4i.durak.data.viewmodels.GameVm
import io.reactivex.Completable
import io.reactivex.Single

interface IGameInteractor {
    fun getGames(): Single<List<GameVm>>
    fun insertGame(gameVm: GameVm): Completable
}