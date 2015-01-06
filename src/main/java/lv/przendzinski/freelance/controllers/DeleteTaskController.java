package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.dto.DeleteInfo;
import lv.przendzinski.freelance.services.TaskService;
import lv.przendzinski.freelance.session.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    private static final Logger LOG = LoggerFactory.getLogger(DeleteTaskController.class);

    @RequestMapping(value = "/task/delete", method = RequestMethod.POST)
    public String assignProcess(@ModelAttribute("deleteInfo")DeleteInfo deleteInfo) {
        taskService.deleteTask(deleteInfo.getTaskID(), currentUser.getId());
        LOG.info("Task deleted: {}", deleteInfo.getTaskID());
        return "redirect:/home";
    }
}