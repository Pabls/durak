package com.ar4i.durak.data.mappers

import com.ar4i.durak.data.db.dto.GameDto
import com.ar4i.durak.data.viewmodels.GameVm

class GamesMapper : IGamesMapper {

    override fun toVms(gameDtos: List<GameDto>): List<GameVm> {
        var gamesVms: MutableList<GameVm> = ArrayList()
        gameDtos.forEach { gamedto: GameDto ->
            gamesVms.add(
                GameVm(
                    gamedto.date,
                    gamedto.isWin,
                    gamedto.gameTime,
                    gamedto.playersNumber
                )
            )
        }
        return gamesVms
    }

    override fun toDto(gameVm: GameVm): GameDto {
        return GameDto(gameVm.date, gameVm.isWin, gameVm.gameTime, gameVm.playersNumber)
    }
}