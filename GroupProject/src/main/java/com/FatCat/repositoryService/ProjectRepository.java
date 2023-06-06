package com.FatCat.repositoryService;

import com.FatCat.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByTitleLike(String theSearchName);

    Project findByTitle(String title);
}
