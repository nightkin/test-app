package lv.przendzinski.freelance.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationProcessController.class);

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationProcess(@ModelAttribute("registerInfo")RegisterInfo registerInfo, Model model) {
        try {
            userService.createUser(
                    registerInfo.getUsername(),
                    registerInfo.getPassword(),
                    registerInfo.getRole()
            );

            LOG.info("New user created: {}", registerInfo.getUsername());
            model.addAttribute("username", registerInfo.getUsername());
            return "home";
        }
        catch (IllegalArgumentException e) {
            LOG.error("Error: {}", e.getMessage());
            model.addAttribute("error", e.getMessage());
        }
        catch (UserAlreadyExistsException e) {
            LOG.error("Error: {}", e.getMessage());
            model.addAttribute("error", e.getMessage());
        }

        return "register";
    }
}
