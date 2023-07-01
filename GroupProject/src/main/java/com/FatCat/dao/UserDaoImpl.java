package com.FatCat.dao;

import com.FatCat.entity.Project;
import com.FatCat.entity.Tag;
import com.FatCat.entity.Task;
import com.FatCat.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private static EntityManager theEntityManager;

    @Autowired
    public UserDaoImpl(EntityManager em){
        this.theEntityManager = em;
    }


    @Override
    public User SaveProject(User user, Project project) {
        return null;
    }

    @Override
    @Transactional
    public User SaveProject(int userId, Project project) {

        List<Tag> selectedTags = project.getTags();
        List<Tag> tags = new ArrayList<>();
        for(Tag t : selectedTags){
            Tag tag = theEntityManager.find(Tag.class, t.getId());
            tags.add(tag);
        }
        project.setTags(tags);
        User user = theEntityManager.find(User.class, userId);
        user.getProjects().add(project);
        theEntityManager.merge(user);
        return user;
    }

    @Override
    @Transactional
    public List<Task> findAllByProject(int id) {
        String sql = "SELECT * FROM task WHERE project_id = :projectId";
        Query query = theEntityManager.createNativeQuery(sql, Task.class);
        query.setParameter("projectId", id);
        return query.getResultList();
    }

    @Override
    public List<Project> findAllUserProjects(User user) {

        return null;
    }

    @Override
    @Transactional
    public boolean deleteProjectByID(int id) {

        Project p = theEntityManager.find(Project.class, id);
        theEntityManager.remove(p);
        if(theEntityManager.find(Project.class, id) == null){
            return true;
        } else{
            return false;
        }
    }
}
