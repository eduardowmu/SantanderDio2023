package dio.me.edu.controller;

import dio.me.edu.dto.UserDTO;
import dio.me.edu.mapper.UserMapper;
import dio.me.edu.model.User;
import dio.me.edu.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ControllerTest {
    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserController userController;

    @Test
    void createTest() {
        UserDTO userDTO = new UserDTO();
        when(this.userMapper.toUserDTO(any())).thenReturn(userDTO);
        User user = new User();
        when(this.userService.save(any())).thenReturn(user);

        Assertions.assertEquals(userDTO, this.userController.create(userDTO).getBody());
    }

    @Test
    void findByIdTest() {
        UserDTO userDTO = new UserDTO();
        when(this.userMapper.toUserDTO(any())).thenReturn(userDTO);
        Optional<User> optionalUser = Optional.of(new User());

        when(this.userService.findById(any())).thenReturn(optionalUser);

        Assertions.assertEquals(userDTO, this.userController.findById(1L).getBody());
    }

    @Test
    void noSuchElementExceptionTEst() {
        UserDTO userDTO = new UserDTO();
        when(this.userMapper.toUserDTO(any())).thenReturn(userDTO);
        when(this.userService.findById(any())).thenThrow(new NoSuchElementException("Não foi encontrado nenhum resultado para a pesquisa"));

        Assertions.assertThrows(NoSuchElementException.class, () -> this.userController.findById(1L));
    }
}