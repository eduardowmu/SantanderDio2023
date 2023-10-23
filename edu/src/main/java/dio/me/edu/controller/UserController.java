package dio.me.edu.controller;

import dio.me.edu.dto.UserDTO;
import dio.me.edu.mapper.UserMapper;
import dio.me.edu.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userMapper.toUserDTO(this.userService.save(userDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userMapper.toUserDTO(this.userService.findById(id).orElseThrow(
                () -> new NoSuchElementException("Não foi encontrado nenhum resultado para a pesquisa"))));
    }
}