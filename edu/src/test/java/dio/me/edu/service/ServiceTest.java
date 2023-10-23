package dio.me.edu.service;

import dio.me.edu.dto.UserDTO;
import dio.me.edu.mapper.UserMapper;
import dio.me.edu.model.User;
import dio.me.edu.repository.UserRepository;
import dio.me.edu.service.impl.UserServiceImpl;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void saveUserTest() {
        User user = new User();
        when(this.userMapper.toUser(any())).thenReturn(user);
        when(this.userRepository.save(any())).thenReturn(user);

        Assertions.assertEquals(user, this.userService.save(new UserDTO()));
    }

    @Test
    void findByIdTest() {
        Optional<User> optionalUser = Optional.of(new User());
        when(this.userRepository.findById(any())).thenReturn(optionalUser);

        Assertions.assertEquals(optionalUser, this.userService.findById(1L));
    }

    @Test
    void illegalArgumentExceptionTest() {
        when(this.userRepository.findById(any())).thenThrow(IllegalArgumentException.class);

        Assertions.assertThrows(IllegalArgumentException.class, () -> this.userService.save(new UserDTO()));
    }
}