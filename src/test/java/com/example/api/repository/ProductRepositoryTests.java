package com.example.api.repository;

import com.example.api.model.Product;
import com.example.api.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveProductWithUser() {
        User user = new User();
        user.setName("Buyer");
        user.setEmail("buyer@example.com");
        User savedUser = userRepository.save(user);

        Product product = new Product();
        product.setName("Smart Watch");
        product.setPrice(199.99);
        product.setUser(savedUser);

        Product savedProduct = productRepository.save(product);

        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isGreaterThan(0);
        assertThat(savedProduct.getUser().getId()).isEqualTo(savedUser.getId());
    }

    @Test
    public void testFindById() {
        Product product = new Product();
        product.setName("Phone");
        product.setPrice(500.0);
        productRepository.save(product);

        Optional<Product> foundProduct = productRepository.findById(product.getId());

        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getName()).isEqualTo("Phone");
    }
}
