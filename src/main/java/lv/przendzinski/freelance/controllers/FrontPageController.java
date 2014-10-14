package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.dto.LoginInfo;
import lv.przendzinski.freelance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontPageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("loginInfo", new LoginInfo());
        return "index";
    }
}
