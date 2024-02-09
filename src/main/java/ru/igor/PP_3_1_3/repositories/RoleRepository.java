package ru.igor.PP_3_1_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.igor.PP_3_1_3.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String role);
}
