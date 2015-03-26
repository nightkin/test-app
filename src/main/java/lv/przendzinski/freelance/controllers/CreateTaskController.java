package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.dto.CreateTaskInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

@Controller
public class CreateTaskController {

    @RequestMapping(value = "/new-task")
    public String registerPage(Model model) {
        model.addAttribute("createTaskInfo", new CreateTaskInfo());
        return "new-task";
    }
}
