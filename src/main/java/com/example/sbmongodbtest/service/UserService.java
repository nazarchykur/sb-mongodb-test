package com.example.sbmongodbtest.service;

import com.example.sbmongodbtest.dto.UserDtoRequest;
import com.example.sbmongodbtest.dto.UserDtoResponse;

import java.util.List;

public interface UserService {
    UserDtoResponse getUserById(String id);
    List<UserDtoResponse> getAllUsers();
    UserDtoResponse createUser(UserDtoRequest userDtoRequest);
    UserDtoResponse updateUser(String id, UserDtoRequest userDtoRequest);
    void deleteUser(String id);
}
