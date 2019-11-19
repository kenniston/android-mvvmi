package br.com.dynamiclight.androidmvvmi.repository.mapper

import br.com.dynamiclight.androidmvvmi.domain.Movie
import br.com.dynamiclight.androidmvvmi.repository.dto.network.MovieDTO
import org.mapstruct.Mapper

@Mapper
interface MovieMapper {

    fun toDTO(domain: Movie): MovieDTO

    fun toDomain(dto: MovieDTO): Movie
}