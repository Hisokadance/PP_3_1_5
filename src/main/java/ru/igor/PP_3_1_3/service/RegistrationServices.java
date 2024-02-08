package ru.igor.PP_3_1_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.repositories.PeopleRepository;

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
        //Шифрование пароля
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        peopleRepository.save(user);
    }
}
