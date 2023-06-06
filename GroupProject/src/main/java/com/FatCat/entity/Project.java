package com.FatCat.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.FatCat.GroupProjectApplication.theEntityManager;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int id;

    @Column(name = "project_type")
    private String projectType;

    @Column(name = "title")
    private String title;

    @Column(name = "short-description")
    private String shortDescription;

    @Column(name = "long-description")
    private String longDescription;

    @Column(name = "repo_link")
    private String repoLink;

    @ManyToMany(fetch=FetchType.EAGER,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(name = "project_tag",
            joinColumns=@JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();


    @ManyToMany(fetch=FetchType.EAGER,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(name = "project_user",
            joinColumns=@JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> members = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<Task> tasks;

    @Column(name = "timestamp")
    private LocalDateTime timeStamp;

    public Project(){

    }

    public Project(String title){
        this.title = title;
        this.timeStamp = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getTags() {
        return this.tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }


    public String getRepoLink() {
        return repoLink;
    }

    public void setRepoLink(String repoLink) {
        this.repoLink = repoLink;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public void setTags(List<Tag> tags) {
//        theEntityManager.merge(tags);
        this.tags = tags;

    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){

        if(this.tasks == null){
            this.tasks = new ArrayList<>();
        }

        this.tasks.add(task);
    }

    @Override
    public String toString() {

        return "Project{" +
                "id=" + id +
                ", projectType='" + projectType + "\n" +
                ", title='" + title + "\n" +
                ", shortDescription='" + shortDescription + "\n" +
                ", longDescription='" + longDescription + "\n" +
                ", repoLink='" + repoLink + "\n" +
                ", tags=" + tags + "\n" +
                ", members=" + members+ "\n" +
                ", timeStamp=" + timeStamp + "\n" +
                '}';
    }
}
