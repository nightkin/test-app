package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.domain.Task;
import lv.przendzinski.freelance.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lv.przendzinski.freelance.session.CurrentUser;

import java.util.List;

/**
 * @author <a href="mailto:kirill.afanasjev@odnoklassniki.ru">Kirill Afanasjev</a>
 */
@Controller
public class HomePageController {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String loginProcess(Model model) {

        if (currentUser.getLogin() == null) {
            return "redirect:";
        }

        List<Task> myTasks = taskService.getMyTasks(currentUser.getId());
        model.addAttribute("username", currentUser.getLogin());
        model.addAttribute("myTasks", myTasks);

        return "home";
    }

}
