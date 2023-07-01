package com.FatCat.dao;

import com.FatCat.entity.Project;
import com.FatCat.entity.Task;
import com.FatCat.entity.User;

import java.util.List;

public interface UserDao {

    User SaveProject(User user, Project project);

    User SaveProject(int userId, Project project);

    public List<Task> findAllByProject(int id);

    public List<Project> findAllUserProjects(User user);

    public boolean deleteProjectByID(int id);
}
