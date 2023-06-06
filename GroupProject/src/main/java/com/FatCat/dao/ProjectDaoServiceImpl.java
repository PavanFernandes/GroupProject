package com.FatCat.dao;

import com.FatCat.entity.Project;
import com.FatCat.repositoryService.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDaoServiceImpl implements ProjectDaoService{

    private ProjectRepository projectRepository;

    @Autowired
     ProjectDaoServiceImpl(ProjectRepository theprojectRepository){
        this.projectRepository = theprojectRepository;
    }


    @Override
    public Project save(Project project) {

        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {

        return projectRepository.findAll();

    }

    @Override
    public Project find(int id) {
        Project project = null;
        Optional<Project> result =  projectRepository.findById(id);

        if(result.isPresent()){
            project = result.get();
        }
      return project;
    }


}
