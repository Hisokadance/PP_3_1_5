package ru.igor.PP_3_1_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igor.PP_3_1_3.model.Role;
import ru.igor.PP_3_1_3.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleServices {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServices(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role findRoleByName(String roleName) {
        return roleRepository.findByName(roleName).orElse(null);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}