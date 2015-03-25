package lv.przendzinski.freelance.services;

import lv.przendzinski.freelance.dao.TaskDao;
import lv.przendzinski.freelance.domain.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */
@Service
public class TaskService {

    @Autowired
    TaskDao taskDao;

    private static final Logger LOG = LoggerFactory.getLogger(TaskService.class);

    public synchronized List<Task> getOpenTasks() {
        return taskDao.getOpenTasks();
    }

    public synchronized List<Task> getMyTasks(long userId) {
        return taskDao.getUserOwnedTasks(userId);
    }

    public synchronized Task getTaskById(long taskId) {
        return taskDao.getTaskById(taskId);
    }

    public synchronized Task viewTask(long taskId, long userId) {
        return taskDao.viewTask(taskId, userId);
    }

    public synchronized void createTask(Task task) {
        taskDao.createTask(task);
    }

    public synchronized void assignTask(long assigneeId, long taskId, long ownerId) {
        taskDao.setAssignee(assigneeId, taskId, ownerId);
    }

    public synchronized void deleteTask(long taskId, long userId) {
        //TODO: forbid deletion by regular user if the task was already assigned
        taskDao.deleteTask(taskId, userId);
    }

}
