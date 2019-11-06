package br.com.dynamiclight.androidmvvmi.repository.mapper

import br.com.dynamiclight.androidmvvmi.domain.User
import br.com.dynamiclight.androidmvvmi.repository.dto.network.UserDTO
import org.mapstruct.Mapper

@Mapper
interface UserMapper {

    fun toDTO(user: User): UserDTO

    fun toDomain(user: UserDTO): User
}