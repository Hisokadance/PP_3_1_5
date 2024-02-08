package ru.igor.PP_3_1_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.igor.PP_3_1_3.service.UserServices;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    //Реализовать показ пользователя
    @GetMapping
    public String getUser(Model model) {
        return "users/user";
    }
    //обновления текущего пользователя

    //удаление текущего пользователя
}
