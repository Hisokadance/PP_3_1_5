package ru.igor.PP_3_1_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.repositories.PeopleRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@Service
public class UserServicesImp implements UserServices {

    private final PeopleRepository peopleRepository;

    @Autowired
    public UserServicesImp(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return peopleRepository.findByUsername(username).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return peopleRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public User readUser(long id) {
        return peopleRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User with id = " + id + " not exist"));
    }

    @Override
    public void save(User user) {
        peopleRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        peopleRepository.deleteById(id);
    }

}
