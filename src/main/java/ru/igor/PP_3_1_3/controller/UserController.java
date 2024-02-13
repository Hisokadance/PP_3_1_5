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
import ru.igor.PP_3_1_3.utill.UserFindRole;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServices userServices;
    private final UserFindRole findRole;

    @Autowired
    public UserController(UserServices userServices, UserFindRole findRole) {
        this.userServices = userServices;
        this.findRole = findRole;
    }

    @GetMapping
    public String showUser( Model model, Principal principal) {
        User user;

        String email = principal.getName();
        user = userServices.findByUsername(email);

        model.addAttribute("authUser", user);
        model.addAttribute("userRoles", findRole.findRole(user));
        return "users/user";
    }
}
