package dio.me.edu.service;

import dio.me.edu.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
}