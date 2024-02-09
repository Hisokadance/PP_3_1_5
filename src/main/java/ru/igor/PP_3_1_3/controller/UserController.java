package ru.igor.PP_3_1_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.igor.PP_3_1_3.model.Role;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.services.UserServices;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public String showUser(@RequestParam(name = "id", required = false) Long id, Model model, Principal principal) {

        User user;

        if (id != null) {
            user = userServices.readUser(id);
        } else {
            String email = principal.getName();
            user = userServices.findByUsername(email);
        }
        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .map(role -> role.split("_")[1])
                .toList();
        model.addAttribute("authUser", user);
        model.addAttribute("userRoles", roles);
        return "users/user";
    }
}
