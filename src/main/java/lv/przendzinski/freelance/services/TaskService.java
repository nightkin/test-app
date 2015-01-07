package lv.przendzinski.freelance.services;

import lv.przendzinski.freelance.domain.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */
@Service
public class TaskService {

    private List<Task> taskList = new ArrayList<Task>();
    private long taskID = 0L;
    private static final Logger LOG = LoggerFactory.getLogger(TaskService.class);

    @PostConstruct
    public void init() {
        Task task1 = new Task(taskID++, "заголовок1", "описание1", 1L, 2L, 100L);
        Task task2 = new Task(taskID++, "заголовок2","описание2", 2L, 3L, 200L);
        Task task3 = new Task(taskID++, "заголовок3","описание3", 3L, 1L, 300L);
        Task task4 = new Task(taskID++, "заголовок4","описание4", 3L, 2L, 400L);
        Task task5 = new Task(taskID++, "заголовок5","описание5", 2L, 1L, 500L);
        Task task6 = new Task(taskID++, "заголовок6","описание6", 1L, 3L, 600L);

        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);
        taskList.add(task5);
        taskList.add(task6);
    }

    public List<Task> getOpenTasks() {
        List<Task> openTasks = new ArrayList<Task>();
        for (Task task : taskList) {
            if (task.getAssignee() == null) {
                openTasks.add(task);
            }
        }
        return openTasks;
    }

    public List<Task> getMyTasks(long userID) {
        List<Task> myTasks = new ArrayList<Task>();
        for (Task task : taskList) {
            if (task.getReporter() == userID) {
                LOG.info("New task created: {}", task);
                myTasks.add(task);
            }
        }
        return myTasks;
    }

    public Task getTaskById(long taskID) {
        for (Task task : taskList) {
            if (task.getId() == taskID) {
                return task;
            }
        }
        return null;
    }

//    public Boolean assignTask(Long taskID, Long currentUserID, Long assigneeID) {
//        return false;
//    }

    public void deleteTask(long taskID, long userID) {
        //TODO: forbid deletion by regular user if the task was already assigned
        Iterator<Task> i = taskList.iterator();
        while (i.hasNext()) {
            Task task = i.next();
            if (task.getId() == taskID) {
                //TODO: check is current user is admin
                if (task.getReporter() == userID) {
                    LOG.info("Task deleted: {}", task.getReporter());
                    i.remove();
                }
                break;
            }
        }
    }

}
