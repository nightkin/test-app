package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.dto.LoginInfo;
import lv.przendzinski.freelance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

@Controller
public class LoginPageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginInfo")LoginInfo loginInfo, Model model) {
        System.out.println(loginInfo);
        Boolean isValid = userService.authenticateUser(loginInfo.getUsername(), loginInfo.getPassword());
        if (isValid) {
            model.addAttribute("username", loginInfo.getUsername());
            return "home";
        }
        return "404";
    }
}