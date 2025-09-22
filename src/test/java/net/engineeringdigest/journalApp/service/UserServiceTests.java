package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest // to start the application context initially all will be null with this the application context will be started then no null values will be there
public class UserServiceTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    @BeforeEach -- Marks a method to be executed before each individual test method within a test class.
//    @BeforeAll --  Marks a method to be executed once before all test methods in the current test class.
//    @AfterEach -- Executes after every test method within a test class.
//    @AfterAll -- Executes only once after all the tests in the entire test class have been completed.
    @BeforeEach
    void setup(){

    }

    @Disabled // ignores the below written test method
    @Test
    public void testFindByUserName(){
        // assertEquals(4, 2+2); // actual should be equal to expected value asserEquals() check whether actual and expected values are same or not -- if both are not equal then gives error
        // assertTrue(5>3);
        User user = userRepository.findByUserName("ram");
        assertTrue(!user.getJournalEntries().isEmpty());
        assertNotNull(user); // asserNotNull() check whether the found user is not null or not -- if null then gives error
    }

    @ParameterizedTest // we are passing parameters to the test method
    // passing the parameters for test method using csv source
    // @CsvSource accepts an array of comma-separated values, and each array entry corresponds to a line in a CSV file.
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,6"
    })
    public void test(int a, int b,int expected){
        assertEquals(expected,a,b);
    }

    @Disabled
    @ParameterizedTest // we are passing parameters to the test method
    // @ValueSource - It allows you to specify an array of primitive types, strings, or classes to be used as arguments for a single test method, which then runs once for each value provided.
    // but @ValueSource won't be enough. So, we need argument sources capable of passing multiple arguments
    @ValueSource(strings = {
            "ram",
            "vaishnavi",
            "akshith"
    })
    public void testFindByUserNameParametrized(String name){
        assertNotNull(userRepository.findByUserName(name));
    }

    @Disabled
    @ParameterizedTest // we are passing parameters to the test method
    // @ValueSource - It allows you to specify an array of primitive types, strings, or classes to be used as arguments for a single test method, which then runs once for each value provided.
    // but @ValueSource won't be enough. So, we need argument sources capable of passing multiple arguments
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewUser(user));
    }
}
