package ru.igor.PP_3_1_3.utill;

import org.springframework.stereotype.Component;
import ru.igor.PP_3_1_3.model.Role;
import ru.igor.PP_3_1_3.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Set;
//нужен для коректного отображения роли
@Component
public class UserFindRole {

    public List<String> findRole(User user) {
        List<String> roles;
        Set<Role> userRoles = user.getRoles();
        if (userRoles != null) {
            roles = userRoles.stream()
                    .map(Role::getName)
                    .map(role -> role.split("_")[1])
                    .toList();
        } else {
            roles = Collections.emptyList(); // возвращает пустой список в случае, если roles == null
        }
        return roles;
    }

}
