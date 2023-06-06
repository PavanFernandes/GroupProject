package com.FatCat.dao;


import com.FatCat.entity.Task;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.FatCat.GroupProjectApplication.theEntityManager;

@Repository
public class TaskDaoImpl {


    public static List<Task> findAllByProject(int id) {
        String sql = "SELECT * FROM task WHERE project_id = :projectId";
        Query query = theEntityManager.createNativeQuery(sql, Task.class);
        query.setParameter("projectId", id);
        return query.getResultList();
    }


}
