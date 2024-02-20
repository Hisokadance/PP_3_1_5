package ru.igor.PP_3_1_3.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import ru.igor.PP_3_1_3.entities.Role;
import ru.igor.PP_3_1_3.entities.User;
import ru.igor.PP_3_1_3.services.UserService;


import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddAttributesToMainPage {

    private final UserService userService;

    @Autowired
    public AddAttributesToMainPage(UserService userService) {
        this.userService = userService;
    }

    public void addAttributesToMainPage(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName()).orElse(new User());

        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .map(role -> role.split("_")[1])
                .collect(Collectors.toList());

        model.addAttribute("authUser", user);
        model.addAttribute("userRoles", roles);

    }
}
