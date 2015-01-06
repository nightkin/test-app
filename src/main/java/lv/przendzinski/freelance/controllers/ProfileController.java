package lv.przendzinski.freelance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.przendzinski.freelance.domain.User;
import lv.przendzinski.freelance.services.UserService;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile/{name}")
    public String getMainPage(Model model, @PathVariable String name) {
        User user = userService.getUserByName(name);
        if (user == null) {
            return "404";
        }
        model.addAttribute("username", user.getName());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("role", user.getRole());
        return "profile";
    }
}