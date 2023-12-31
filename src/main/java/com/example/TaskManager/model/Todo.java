package com.example.TaskManager.model;



import jakarta.validation.constraints.Size;
import java.util.Date;
import jakarta.persistence.*;




@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    @Size(min = 10, message = "Enter at least 10 Characters...")
    private String description;

    private Date targetDate;

    public Todo() {
        super();// to call the object class
    }

    public Todo(String user, String desc, Date targetDate, boolean isDone) {
        super();// to call the object class
        this.userName = user;
        this.description = desc;
        this.targetDate = targetDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}
