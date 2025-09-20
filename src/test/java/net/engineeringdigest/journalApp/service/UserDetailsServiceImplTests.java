package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

// @ActiveProfiles("dev") -- Activates specific Spring profiles during testing
public class UserDetailsServiceImplTests {
    @InjectMocks // Creates real object and injects mocks into it
    private UserDetailsServiceImpl userDetailsService;

    @Mock // Creates fake/mock object for testing
    private UserRepository userRepository;

    @BeforeEach // Runs this method before each test
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    
    @Test // Marks method as a test case
    void loadUserByUsername(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("ram").password("ram1234").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}