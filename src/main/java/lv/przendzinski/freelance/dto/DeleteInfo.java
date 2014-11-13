package lv.przendzinski.freelance.dto;

/**
 * Created by denissprzendzinskis on 14/10/14.
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
