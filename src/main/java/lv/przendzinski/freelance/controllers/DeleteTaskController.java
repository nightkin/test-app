package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.dto.DeleteInfo;
import lv.przendzinski.freelance.services.TaskService;
import lv.przendzinski.freelance.session.CurrentUser;
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
public class DeleteTaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CurrentUser currentUser;

    @RequestMapping(value = "/task/delete", method = RequestMethod.POST)
    public String assignProcess(@ModelAttribute("deleteInfo")DeleteInfo deleteInfo) {
        System.out.println(deleteInfo.getTaskID());
        taskService.deleteTask(deleteInfo.getTaskID(), currentUser.getId());
        return "redirect:/home";
    }
}