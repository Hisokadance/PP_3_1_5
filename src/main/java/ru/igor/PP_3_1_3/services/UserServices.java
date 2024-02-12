package ru.igor.PP_3_1_3.services;

import ru.igor.PP_3_1_3.model.User;

import java.util.List;

public interface UserServices {

    User findByUsername(String username);

    List<User> findAll();

    User findByEmail(String email);

    User readUser(long id);

    void save(User user);

    void delete(Long id);

}
