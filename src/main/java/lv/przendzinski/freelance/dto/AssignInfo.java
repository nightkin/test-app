package lv.przendzinski.freelance.dto;

/**
 * Created by denissprzendzinskis on 14/10/14.
 */

public class AssignInfo {
    private Long taskID;
    private Long assigneeID;

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public Long getAssigneeID() {
        return assigneeID;
    }

    public void setAssigneeID(Long assigneeID) {
        this.assigneeID = assigneeID;
    }

    @Override
    public String toString() {
        return "AssignInfo{" +
                "taskID='" + taskID + '\'' +
                ", assigneeID='" + assigneeID + '\'' +
                '}';
    }
}
