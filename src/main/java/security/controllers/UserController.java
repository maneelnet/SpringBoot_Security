package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import security.models.User;
import security.services.UserService;

import java.security.Principal;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String showUserInfo(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute(user);
        return "user";
    }

}
