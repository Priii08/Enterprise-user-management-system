package com.user.service.impl;

import com.user.exception.BadRequestException;
import com.user.exception.ResourceNotFoundException;
import com.user.model.dto.UserDto;
import com.user.model.entity.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserDto saveUser(UserDto userDto) {
        if(userDto.getId() != null){
            throw new RuntimeException("User already exists");
        }
        User entity = modelMapper.map(userDto, User.class);
        User savedEntity = userRepository.save(entity);
        return modelMapper.map(savedEntity, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        if(id == null || userDto.getId() == null){
            throw new BadRequestException("Please provide employee id");
        }
        if(!Objects.equals(id, userDto.getId())){
            throw new BadRequestException("Id mismatch");
        }

        userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id, HttpStatus.NOT_FOUND));

        User entity = modelMapper.map(userDto, User.class);
        User updatedUser = userRepository.save(entity);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        User user =  userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+ id, HttpStatus.NOT_FOUND));
        userRepository.delete(user);
    }

    @Override
    public UserDto getSingleUser(Long id) {
        User user =  userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id, HttpStatus.NOT_FOUND));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            throw new ResourceNotFoundException("No users found", HttpStatus.NOT_FOUND);
        }
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();

    }

    @Override
    public UserDto getUserByUserCodeAndCompanyName(String userCode, String companyName) {
        User user = userRepository.findByUserCodeAndCompanyName(userCode, companyName).orElseThrow(()-> new ResourceNotFoundException("User not found with userCode: "
                + userCode + " and companyName: " + companyName, HttpStatus.NOT_FOUND));
        return modelMapper.map(user, UserDto.class);
    }
}
