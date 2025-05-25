import org.example.User;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
// EXO1
public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setup() {
        userRepository = mock(UserRepository.class); // Mocking
        userService = new UserService(userRepository); // Injection du mock
    }

    @Test
    public void testGetUserById_callsRepositoryAndReturnsUser() {
        // Arrange
        long userId = 1L;
        User expectedUser = new User(userId, "amine siad");
        when(userRepository.findUserById(userId)).thenReturn(expectedUser);

        // Act
        User actualUser = userService.getUserById(userId);

        // Assert
        assertEquals(expectedUser, actualUser);
        verify(userRepository).findUserById(userId); // Vérifie que le mock a été appelé avec le bon ID
    }
}
