package lv.przendzinski.freelance.dto;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */

public class CreateTaskInfo {
    private String title;
    private String description;
    private String deadline;
    private long bounty;

    public long getBounty() {
        return bounty;
    }

    public void setBounty(long bounty) {
        this.bounty = bounty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}
