package com.ar4i.durak.data.dao

import com.ar4i.durak.data.dto.GameDto
import io.reactivex.Completable
import io.reactivex.Single

interface IGamesDao {
    fun getGames(): Single<List<GameDto>>
    fun insertGame(gameDto: GameDto): Completable
}