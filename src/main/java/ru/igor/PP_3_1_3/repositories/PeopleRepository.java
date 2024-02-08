package ru.igor.PP_3_1_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.igor.PP_3_1_3.model.User;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
