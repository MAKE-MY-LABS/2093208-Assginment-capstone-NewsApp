package com.capstone.newsapp.repository;

import com.capstone.newsapp.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserRepositoryTest {

    @InjectMocks
    private UserRepository userRepository;

    @Mock
    private UserRepository userRepositoryMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByEmailIdAndPassword() {
        User user = new User();
        String email = "test@test.com";
        String password = "password";
        when(userRepositoryMock.findByEmailIdAndPassword(email, password)).thenReturn(Optional.of(user));
        Optional<User> result = userRepository.findByEmailIdAndPassword(email, password);
        assertEquals(user, result.get());
    }
}
