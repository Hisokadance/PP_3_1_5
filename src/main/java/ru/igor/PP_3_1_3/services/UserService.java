package ru.igor.PP_3_1_3.services;


import ru.igor.PP_3_1_3.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    User add(User user);

    void update(User updatedUser);

    Optional<User> readUser(Long id);

    void delete(Long id);

    Optional<User> findByEmail(String email);
}
