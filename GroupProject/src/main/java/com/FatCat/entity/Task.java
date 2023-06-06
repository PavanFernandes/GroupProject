package com.FatCat.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "task_points")
    private int taskPoints;

    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;

    @Column(name = "task_done_by_user_id")
    private int taskDoneByUserId;

    public Task(){

    }

    public Task(String title, String description, int taskPoints, LocalDateTime createdDateTime, int taskDoneByUserId) {
        this.title = title;
        this.description = description;
        this.taskPoints = taskPoints;
        this.createdDateTime = createdDateTime;
        this.taskDoneByUserId = taskDoneByUserId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

    public int getTaskPoints() {
        return taskPoints;
    }

    public void setTaskPoints(int taskPoints) {
        this.taskPoints = taskPoints;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public int getTaskDoneByUserId() {
        return taskDoneByUserId;
    }

    public void setTaskDoneByUserId(int taskDoneByUserId) {
        this.taskDoneByUserId = taskDoneByUserId;
    }
}
