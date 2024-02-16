package ru.igor.PP_3_1_3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.igor.PP_3_1_3.services.RoleService;
import ru.igor.PP_3_1_3.util.AddAttributesToMainPage;


import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final RoleService roleService;

    private final AddAttributesToMainPage addAttributesToMainPage;

    @Autowired
    public AdminController(RoleService roleService, AddAttributesToMainPage addAttributesToMainPage) {
        this.roleService = roleService;
        this.addAttributesToMainPage = addAttributesToMainPage;
    }

    @GetMapping("/users")
    public String getUsersList(Principal principal, Model model) {
        addAttributesToMainPage.addAttributesToMainPage(model, principal);
        model.addAttribute("listRoles", roleService.findAll());
        return "admin/control-panel";
    }
}
