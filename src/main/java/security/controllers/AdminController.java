package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import security.models.User;
import security.services.RoleService;
import security.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private RoleService roleService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.usersList());
        return "admin";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("roles", roleService.rolesList());
        model.addAttribute("user", new User());
        return "user_form";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin/";
    }

    @GetMapping("edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("roles", roleService.rolesList());
        model.addAttribute("user", userService.showUser(id));
        return "user_form";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/";
    }

}
