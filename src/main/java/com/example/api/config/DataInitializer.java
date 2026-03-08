package com.example.api.config;

import com.example.api.model.Product;
import com.example.api.model.User;
import com.example.api.repository.ProductRepository;
import com.example.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, ProductRepository productRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                User user1 = new User();
                user1.setName("Alice Wonderland");
                user1.setEmail("alice@example.com");

                User user2 = new User();
                user2.setName("Bob Builder");
                user2.setEmail("bob@example.com");

                User user3 = new User();
                user3.setName("Charlie Chaplin");
                user3.setEmail("charlie@example.com");

                userRepository.saveAll(List.of(user1, user2, user3));

                Product p1 = new Product();
                p1.setDescription("Laptop");
                p1.setName("Laptop");
                p1.setPrice(1500.0);
                p1.setUser(user1);

                Product p2 = new Product();
                p2.setDescription("Mouse");
                p2.setName("Mouse");
                p2.setPrice(25.0);
                p2.setUser(user1);

                Product p3 = new Product();
                p3.setDescription("Keyboard");
                p3.setName("Keyboard");
                p3.setPrice(50.0);
                p3.setUser(user2);

                productRepository.saveAll(List.of(p1, p2, p3));

                System.out.println(">>> Dummy data (users & products) injected successfully.");
            } else {
                System.out.println(">>> Database already has data. Skipping injection.");
            }
        };
    }
}
