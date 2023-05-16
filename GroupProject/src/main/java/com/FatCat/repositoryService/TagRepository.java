package com.FatCat.repositoryService;

import com.FatCat.entity.project.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
