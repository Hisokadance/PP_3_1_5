package ru.igor.PP_3_1_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.services.RegistrationServices;
import ru.igor.PP_3_1_3.utill.UserValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserValidator userValidator;
    private final RegistrationServices registrationServices;

    @Autowired
    public AuthController(UserValidator userValidator, RegistrationServices registrationServices) {
        this.userValidator = userValidator;
        this.registrationServices = registrationServices;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistrationPage(@ModelAttribute("user") @Valid User user,
                                          BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/auth/registration";
        }

        registrationServices.register(user);
        return "redirect:/auth/login";
    }
}
