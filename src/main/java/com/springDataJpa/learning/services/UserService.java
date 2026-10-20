package com.springDataJpa.learning.services;


import com.springDataJpa.learning.DTO.CreateUserDto;
import com.springDataJpa.learning.DTO.UserDto;
import com.springDataJpa.learning.entities.User;
import com.springDataJpa.learning.exceptions.ResourceNotFoundException;
import com.springDataJpa.learning.mappers.UserMapper;
import com.springDataJpa.learning.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(CreateUserDto createUserDto) {

        User user = new User();
        user.setName(createUserDto.getName());
        user.setEmail(createUserDto.getEmail());

        User savedUser = userRepository.save(user);


        UserDto userDto = new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setName(savedUser.getName());
        userDto.setEmail(savedUser.getEmail());

        return  userDto;
    }

    public UserDto getUserByID(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not Found with ID: " + id));

        return userMapper.toDto(user);
    }

    public UserDto updateUser (Long id, CreateUserDto createUserDto){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Failed To Update. User not Found with ID: " + id));

        user.setName(createUserDto.getName());
        user.setEmail(createUserDto.getEmail());

        User updateduser = userRepository.save(user);

        return userMapper.toDto(updateduser);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Failed To Delete. User not Found with ID: " + id));

        userRepository.deleteById(id);

    }
}
