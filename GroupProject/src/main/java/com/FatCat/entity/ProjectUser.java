package com.FatCat.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project_user")
public class ProjectUser {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_role")
    private String role;

    @Column(name = "contribution_points")
    private String contributionPoints;

    ProjectUser(){

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContributionPoints() {
        return contributionPoints;
    }

    public void setContributionPoints(String contributionPoints) {
        this.contributionPoints = contributionPoints;
    }
}
