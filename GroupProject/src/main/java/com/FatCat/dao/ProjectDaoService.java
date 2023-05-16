package com.FatCat.dao;

import com.FatCat.entity.project.Project;

import java.util.List;

public interface ProjectDaoService {

    Project save(Project project);

    List<Project> findAll();

    Project find(int id);





}
