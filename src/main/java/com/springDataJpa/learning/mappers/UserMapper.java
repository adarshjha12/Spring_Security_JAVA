package com.springDataJpa.learning.mappers;


import com.springDataJpa.learning.DTO.UserDto;
import com.springDataJpa.learning.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
