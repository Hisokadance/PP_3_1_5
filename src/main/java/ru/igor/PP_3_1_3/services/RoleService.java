package ru.igor.PP_3_1_3.services;


import ru.igor.PP_3_1_3.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role save(Role role);

    List<Role> findAll();

    Optional<Role> findById(Long id);

    void deleteById(Long id);

    Optional<Role> findByName(String name);
}
