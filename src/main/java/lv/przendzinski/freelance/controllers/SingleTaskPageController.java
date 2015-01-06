package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.domain.Task;
import lv.przendzinski.freelance.dto.DeleteInfo;
import lv.przendzinski.freelance.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

@Controller
public class SingleTaskPageController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/task/{taskID}", method = RequestMethod.GET)
    public String taskDetails(Model model, @PathVariable long taskID) {
        model.addAttribute("deleteInfo", new DeleteInfo());
        Task currentTask = taskService.getTaskById(taskID);
        model.addAttribute("task", currentTask);
        return "task";
    }
}
