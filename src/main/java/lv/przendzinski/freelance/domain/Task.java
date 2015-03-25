package lv.przendzinski.freelance.domain;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */
public class Task {
    private long id;
    private String title;
    private String description;
    private long reporter;
    private Long assignee;
    private long dateCreated;
    private Long deadline;
    private long bounty;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getBounty() {
        return bounty;
    }

    public void setBounty(long bounty) {
        this.bounty = bounty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getReporter() {
        return reporter;
    }

    public void setReporter(long reporter) {
        this.reporter = reporter;
    }

    public Long getAssignee() {
        return assignee;
    }

    public void setAssignee(Long assignee) {
        this.assignee = assignee;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }



//    public Task(String title, String description, long reporter, long deadline, long bounty) {
//        this.setTitle(title);
//        this.setDescription(description);
//        this.setReporter(reporter);
//        this.setDeadline(deadline);
//        this.setBounty(bounty);
//        this.setDateCreated(System.currentTimeMillis());
//    }

}
