package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.dto.RegisterInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

@Controller
public class RegisterPageController {

    @RequestMapping(value = "/register")
    public String registerPage(Model model) {
        model.addAttribute("registerInfo", new RegisterInfo());
        return "register";
    }
}
