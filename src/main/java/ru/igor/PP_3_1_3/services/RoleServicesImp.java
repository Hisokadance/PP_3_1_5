package ru.igor.PP_3_1_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.igor.PP_3_1_3.model.Role;
import ru.igor.PP_3_1_3.repositories.RoleRepository;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class RoleServicesImp implements RoleServices {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServicesImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}