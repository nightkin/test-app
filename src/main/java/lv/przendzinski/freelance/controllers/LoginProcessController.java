package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.domain.User;
import lv.przendzinski.freelance.dto.LoginInfo;
import lv.przendzinski.freelance.services.UserService;
import lv.przendzinski.freelance.session.CurrentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

@Controller
public class LoginProcessController {

    @Autowired
    private UserService userService;

    @Autowired
    private CurrentUser currentUser;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("loginInfo")LoginInfo loginInfo) {
        Boolean isValid = userService.authenticateUser(loginInfo.getUsername(), loginInfo.getPassword());

        if (isValid) {
            User user = userService.getUserByName(loginInfo.getUsername());
            currentUser.setLogin(loginInfo.getUsername());
            currentUser.setId(user.getId());
            return "redirect:home";
        }
        return "404";
    }
}