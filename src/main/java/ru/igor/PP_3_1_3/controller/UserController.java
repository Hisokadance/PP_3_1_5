package ru.igor.PP_3_1_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.service.UserServices;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public String showBasePage(Model model, Principal principal) {
        String username = principal.getName();
        User user = userServices.getUserByUsername(username);
        model.addAttribute("user", user);
        return "users/news";
    }

    @GetMapping("/info/{id}")
    public String userInfo(@PathVariable("id") Long id, Model model) {
        User user = userServices.getUser(id);
        model.addAttribute("user", user);
        return "users/user";
    }
}
