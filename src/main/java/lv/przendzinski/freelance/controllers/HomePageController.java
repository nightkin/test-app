package lv.przendzinski.freelance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lv.przendzinski.freelance.session.CurrentUser;

/**
 * @author <a href="mailto:kirill.afanasjev@odnoklassniki.ru">Kirill Afanasjev</a>
 */
@Controller
public class HomePageController {

    @Autowired
    private CurrentUser currentUser;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String loginProcess(Model model) {
        model.addAttribute("username", currentUser.getLogin());
        return "home";
    }

}
