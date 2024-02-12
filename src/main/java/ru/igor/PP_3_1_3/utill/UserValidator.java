package ru.igor.PP_3_1_3.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.services.UserDetailsServicesImpl;
import ru.igor.PP_3_1_3.services.UserServices;

@Component
public class UserValidator implements Validator {

    private final UserServices userServices;

    @Autowired
    public UserValidator( UserServices userServices) {
        this.userServices = userServices;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        // Проверка на уникальность адреса электронной почты (email)
        User existingUser = userServices.findByEmail(user.getEmail());
        if (existingUser != null) {
            errors.rejectValue("email", "", "Пользователь с таким адресом электронной почты уже существует");
        }

        // Проверка на уникальность имени пользователя (username)
        User existingUserByUsername = userServices.findByUsername(user.getUsername());
        if (existingUserByUsername != null) {
            errors.rejectValue("username", "", "Пользователь с таким username уже существует");
        }
    }
}
