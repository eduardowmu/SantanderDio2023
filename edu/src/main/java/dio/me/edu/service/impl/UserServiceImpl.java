package dio.me.edu.service.impl;

import dio.me.edu.dto.UserDTO;
import dio.me.edu.mapper.UserMapper;
import dio.me.edu.model.User;
import dio.me.edu.repository.UserRepository;
import dio.me.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User save(UserDTO userDTO) {
        if(userDTO.getId() != null) {
            Optional<User> optionalUser = this.findById(userDTO.getId());
            return this.userRepository.save(optionalUser.get());
        }
        return this.userRepository.save(this.userMapper.toUser(userDTO));
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }
}