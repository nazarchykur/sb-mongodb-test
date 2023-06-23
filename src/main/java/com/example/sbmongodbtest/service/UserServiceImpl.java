package com.example.sbmongodbtest.service;

import com.example.sbmongodbtest.dto.UserDtoRequest;
import com.example.sbmongodbtest.dto.UserDtoResponse;
import com.example.sbmongodbtest.entity.User;
import com.example.sbmongodbtest.exception.EntityNotFoundException;
import com.example.sbmongodbtest.repository.UserRepository;
import com.example.sbmongodbtest.util.DtoMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DtoMapperUtil dtoMapperUtil;

    @Override
    public UserDtoResponse getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return dtoMapperUtil.toDto(user, UserDtoResponse.class);
    }

    @Override
    public List<UserDtoResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> dtoMapperUtil.toDto(user, UserDtoResponse.class))
                .toList();
    }

    @Override
    public UserDtoResponse createUser(UserDtoRequest userDtoRequest) {
        User user = dtoMapperUtil.toEntity(userDtoRequest, User.class);
        User savedUser = userRepository.save(user);
        return dtoMapperUtil.toDto(savedUser, UserDtoResponse.class);
    }

    @Override
    public UserDtoResponse updateUser(String id, UserDtoRequest userDtoRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setName(userDtoRequest.getName());
        user.setEmail(userDtoRequest.getEmail());
        return dtoMapperUtil.toDto(user, UserDtoResponse.class);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
