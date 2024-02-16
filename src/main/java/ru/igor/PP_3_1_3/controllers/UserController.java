package ru.igor.PP_3_1_3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.igor.PP_3_1_3.util.AddAttributesToMainPage;


import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final AddAttributesToMainPage addAttributesToMainPage;

    @Autowired
    public UserController(AddAttributesToMainPage addAttributesToMainPage) {
        this.addAttributesToMainPage = addAttributesToMainPage;
    }

    @GetMapping
    public String showUser(Model model, Principal principal) {
        addAttributesToMainPage.addAttributesToMainPage(model, principal);
        return "/user/user-info";
    }
}
