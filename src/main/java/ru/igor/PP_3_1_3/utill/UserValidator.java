package ru.igor.PP_3_1_3.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.services.UserDetailsServicesImpl;

@Component
public class UserValidator implements Validator {

    private final UserDetailsServicesImpl userDetailsServices;

    @Autowired
    public UserValidator(UserDetailsServicesImpl userDetailsServices) {
        this.userDetailsServices = userDetailsServices;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        try {
            //создать свой сервис который будет возваращать Optional и вместо исключения проверять есть ли чевовек или нет
            userDetailsServices.loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException ignored) {
            return;
        }
        errors.rejectValue("username", "", "Человек с таким именнем существует");

    }
}
