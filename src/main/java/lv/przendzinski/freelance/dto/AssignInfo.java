package lv.przendzinski.freelance.dto;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

public class AssignInfo {
    private long taskID;
    private Long assigneeID;

    public long getTaskID() {
        return taskID;
    }

    public void setTaskID(long taskID) {
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
