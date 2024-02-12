package ru.igor.PP_3_1_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.repositories.PeopleRepository;
import ru.igor.PP_3_1_3.security.UserDetailsImpl;

import java.util.Optional;

@Service
public class UserDetailsServicesImpl implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public UserDetailsServicesImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = peopleRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return new UserDetailsImpl(user.get());
    }
}
