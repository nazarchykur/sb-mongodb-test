package com.example.sbmongodbtest.repository;

import com.example.sbmongodbtest.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
