package ru.igor.PP_3_1_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.igor.PP_3_1_3.model.User;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u left join fetch u.roles where u.username=:username")
    Optional<User> findByUsername(String username);

    @Query("Select u from User u left join fetch u.roles where u.email=:email")
    User findByEmail(String email);

}

