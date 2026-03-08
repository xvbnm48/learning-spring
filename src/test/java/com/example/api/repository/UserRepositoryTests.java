package com.example.api.repository;

import com.example.api.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("Test User");
        user.setEmail("test@example.com");

        User savedUser = userRepository.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
        assertThat(savedUser.getName()).isEqualTo("Test User");
    }

    @Test
    public void testFindById() {
        User user = new User();
        user.setName("Alice");
        user.setEmail("alice@example.com");
        userRepository.save(user);

        Optional<User> foundUser = userRepository.findById(user.getId());

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getName()).isEqualTo("Alice");
    }
}
