package com.ar4i.durak.data.mappers

import com.ar4i.durak.data.db.dto.GameDto
import com.ar4i.durak.data.viewmodels.GameVm

interface IGamesMapper {
    fun toVms(gameDtos: List<GameDto>): List<GameVm>
    fun toDto(gameVm: GameVm): GameDto
}