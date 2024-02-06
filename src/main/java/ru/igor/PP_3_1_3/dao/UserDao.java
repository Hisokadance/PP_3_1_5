package ru.igor.PP_3_1_3.dao;

import ru.igor.PP_3_1_3.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User updateUser);

    void deleteUser(Integer id);

    User getUser(Integer id);
}
