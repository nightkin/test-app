package lv.przendzinski.freelance.controllers;

import lv.przendzinski.freelance.domain.Task;
import lv.przendzinski.freelance.dto.CreateTaskInfo;
import lv.przendzinski.freelance.services.TaskService;
import lv.przendzinski.freelance.session.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

@Controller
public class TaskCreationProcessController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CurrentUser currentUser;

    private static final Logger LOG = LoggerFactory.getLogger(TaskCreationProcessController.class);

    @RequestMapping(value = "/task-creation", method = RequestMethod.POST)
    public String taskCreationProcess(@ModelAttribute("createTaskInfo")CreateTaskInfo createTaskInfo, Model model) {
        try {
            Task task = new Task();

            if (createTaskInfo.getDeadline().isEmpty()) {
                task.setDeadline(null);
            } else {
                Long convertedDeadline = new SimpleDateFormat("yyyy-mm-dd").parse(createTaskInfo.getDeadline()).getTime();
                task.setDeadline(convertedDeadline);
            }

            task.setTitle(createTaskInfo.getTitle());
            task.setDescription(createTaskInfo.getDescription());
            task.setBounty(createTaskInfo.getBounty());
            task.setDateCreated(System.currentTimeMillis());
            task.setReporter(currentUser.getId());

            taskService.createTask(task);

            LOG.info("New task created: {}", task);

            return "home";
        } catch (IllegalArgumentException e) {
            LOG.error("Error: {}", e);
            model.addAttribute("error", e.getMessage());
        } catch (ParseException e) {
            LOG.error("Error: {}", e);
            model.addAttribute("error", e.getMessage());
        }

        return "new-task";
    }
}
