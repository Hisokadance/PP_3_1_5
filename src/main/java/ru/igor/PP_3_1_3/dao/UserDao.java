package ru.igor.PP_3_1_3.dao;

import ru.igor.PP_3_1_3.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User updateUser);

    void deleteUser(Long id);

    User getUser(Long id);

    User getUserByUsername(String username);
}
