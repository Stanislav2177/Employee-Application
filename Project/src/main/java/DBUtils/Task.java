package DBUtils;

import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Date givenAt;
    private Date dueDate;
    private String finishedAt;

    public Task(int id, String title, String description, Date givenAt, Date dueDate, String finishedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.givenAt = givenAt;
        this.dueDate = dueDate;
        this.finishedAt = finishedAt;
    }

    public Date getGivenAt() {
        return givenAt;
    }

    public void setGivenAt(Date givenAt) {
        this.givenAt = givenAt;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
                .append(", title: ").append(title)
                .append(", description: ").append(description)
                .append(", given at: ").append(givenAt)
                .append(", due date: ").append(dueDate)
                .append(", finished: ").append(finishedAt == null ? "still not finished" : finishedAt);
        return sb.toString();
    }
}
