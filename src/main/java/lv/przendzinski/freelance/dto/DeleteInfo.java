package lv.przendzinski.freelance.dto;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

public class DeleteInfo {
    private Long taskID;

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    @Override
    public String toString() {
        return "DeleteInfo{" +
                "taskID='" + taskID + '\'' +
                '}';
    }
}
