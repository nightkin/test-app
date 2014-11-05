package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.domain.UserAlreadyExistsException;
import lv.przendzinski.freelance.dto.RegisterInfo;
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
public class RegistrationProcessController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationProcess(@ModelAttribute("registerInfo")RegisterInfo registerInfo, Model model) {
        System.out.println(registerInfo);

        try {
            userService.createUser(
                    registerInfo.getUsername(),
                    registerInfo.getPassword(),
                    registerInfo.getRole()
            );

            model.addAttribute("username", registerInfo.getUsername());
            return "home";
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            model.addAttribute("error", e.getMessage());
        }
        catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
            model.addAttribute("error", e.getMessage());
        }

        return "register";
    }
}
