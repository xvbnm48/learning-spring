package com.example.api.controller;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllUsers() throws Exception {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Alice");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Bob");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Alice"))
                .andExpect(jsonPath("$[1].name").value("Bob"));
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Alice");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setName("New User");
        user.setEmail("new@example.com");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setName("New User");
        savedUser.setEmail("new@example.com");

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("New User"));
    }
}
