package com.example.sbmongodbtest.repository;

import com.example.sbmongodbtest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@Testcontainers
@ContextConfiguration(classes = MongoDBTestContainerConfig.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findById_dataExist() {
        // Arrange
        User user = new User();
        user.setName("John");
        user.setEmail("john@example.com");
        userRepository.save(user);

        // Act
        User userResult = userRepository.findById(user.getId()).orElse(null);

        // Assert
        assertThat(userResult).isNotNull();
        assertThat(userResult.getName()).isEqualTo("John");
        assertThat(userResult.getEmail()).isEqualTo("john@example.com");
    }

    @Test
    void findById_dataDoesNotExist() {
        // Act
        Optional<User> userResult = userRepository.findById("1");

        // Assert
        assertThat(userResult).isEmpty();
    }

    @Test
    void save_newUser() {
        // Arrange
        User user = new User();
        user.setName("John");
        user.setEmail("john@example.com");

        // Act
        User savedUser = userRepository.save(user);

        // Assert
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("John");
        assertThat(savedUser.getEmail()).isEqualTo("john@example.com");
    }

    @Test
    void save_updateUser() {
        // Arrange
        User user = new User();
        user.setName("John");
        user.setEmail("john@example.com");
        userRepository.save(user);

        // Act
        user.setName("Updated Name");
        User updatedUser = userRepository.save(user);

        // Assert
        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getId()).isEqualTo(user.getId());
        assertThat(updatedUser.getName()).isEqualTo("Updated Name");
        assertThat(updatedUser.getEmail()).isEqualTo("john@example.com");
    }
}