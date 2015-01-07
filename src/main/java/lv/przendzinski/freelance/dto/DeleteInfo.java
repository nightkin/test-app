package lv.przendzinski.freelance.dto;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

public class DeleteInfo {
    private long taskID;

    public long getTaskID() {
        return taskID;
    }

    public void setTaskID(long taskID) {
        this.taskID = taskID;
    }

    @Override
    public String toString() {
        return "DeleteInfo{" +
                "taskID='" + taskID + '\'' +
                '}';
    }
}
