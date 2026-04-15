package com.user.service;

import com.user.model.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDto);
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
    UserDto getSingleUser(Long id);
    List<UserDto> getAllUsers();


    UserDto getUserByUserCodeAndCompanyName(String userCode, String companyName);
}
