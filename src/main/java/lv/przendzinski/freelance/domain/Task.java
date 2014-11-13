package lv.przendzinski.freelance.domain;

/**
 * @author <a href="mailto:nightkin@gmail.com">Dennis Przendzinski</a>
 */
public class Task {
    private Long id;
    private String title;
    private String description;
    private Long reporter;
    private Long assignee;
    private Long dateCreated;
    private Long deadline;
    private Long bounty;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getBounty() {
        return bounty;
    }

    public void setBounty(Long bounty) {
        this.bounty = bounty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getReporter() {
        return reporter;
    }

    public void setReporter(Long reporter) {
        this.reporter = reporter;
    }

    public Long getAssignee() {
        return assignee;
    }

    public void setAssignee(Long assignee) {
        this.assignee = assignee;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public Task(Long id, String title, String description, Long owner, Long deadline, Long bounty) {
        this.setId(id);
        this.setTitle(title);
        this.setDescription(description);
        this.setReporter(owner);
        this.setDeadline(deadline);
        this.setBounty(bounty);
        this.setDateCreated(System.currentTimeMillis());
    }

}
