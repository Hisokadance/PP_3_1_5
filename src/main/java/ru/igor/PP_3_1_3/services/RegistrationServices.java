package ru.igor.PP_3_1_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.igor.PP_3_1_3.model.Role;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.repositories.PeopleRepository;

import java.util.HashSet;

@Transactional
@Service
public class RegistrationServices {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServices(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Инициализация roles, если она null
        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>());
        }

        Role userRole = new Role(1L, "ROLE_ADMIN");
        userRole.setName("ROLE_ADMIN");
        user.getRoles().add(userRole);
        peopleRepository.save(user);
    }
}
