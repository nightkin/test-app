package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.dto.LoginInfo;
import lv.przendzinski.freelance.domain.Task;
import lv.przendzinski.freelance.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class FrontPageController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("loginInfo", new LoginInfo());

        List<Task> openTasks = taskService.getOpenTasks();
        model.addAttribute("openTasks", openTasks);
        return "index";
    }
}
