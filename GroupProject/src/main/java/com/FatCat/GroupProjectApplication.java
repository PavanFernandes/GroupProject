package com.FatCat;

import com.FatCat.repositoryService.TagRepository;
import com.FatCat.repositoryService.TaskRepository;
import com.FatCat.repositoryService.UserRepository;
import com.FatCat.repositoryService.ProjectRepository;
import com.FatCat.entity.Project;
import com.FatCat.entity.Tag;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class GroupProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupProjectApplication.class, args);



	}


	public static ProjectRepository theprojectRepository;
	public static TaskRepository theTaskRepository;
	public static TagRepository theTagRepository;
	public static UserRepository theUserRepository;
	public static EntityManager theEntityManager;


	@Autowired
	GroupProjectApplication(ProjectRepository projectRepository, TagRepository tagRepository,
							TaskRepository taskRepository, UserRepository userRepository, EntityManager entityManager){

         theprojectRepository = projectRepository;
		 theTaskRepository = taskRepository;
		 theTagRepository = tagRepository;
		 theUserRepository = userRepository;
		 theEntityManager = entityManager;
	}



	public static void load2(){

		Tag java = new Tag("java");
		Tag javascript = new Tag("java script");
		Tag python = new Tag("python");
		Tag csharp = new Tag("C#");
		Tag jenkins = new Tag("jenkins");
		Tag spring = new Tag("spring");

		theTagRepository.save(java);
		theTagRepository.save(javascript);
		theTagRepository.save(python);
		theTagRepository.save(csharp);
		theTagRepository.save(jenkins);
		theTagRepository.save(spring);


//		Project project1 = new Project("Fat CAt", "this is project made for fun");
//		Project project2 = new Project("MIT App Inventor", "Anyone can build apps with global impact");
//		Project project3 = new Project("AOSSIE", " Australian Umbrella Org for Open-Source Projects");
//		Project project4 = new Project("libvirt", "Libvirt is a library and toolkit providing abstraction for various hypervisors. It can be used from a number of languages.");
//		Project project5 = new Project("Jenkins X", "Accelerate Your Continuous Delivery on Kubernetes");



//		project1.addTag(java);
//        project1.addTag(spring);
//		project2.addTag(javascript);
//		project3.addTag(python);
//		project4.addTag(csharp);
//		project5.addTag(jenkins);


//
//		theprojectRepository.save(project1);
//		theprojectRepository.save(project2);
//		theprojectRepository.save(project3);
//		theprojectRepository.save(project4);
//		theprojectRepository.save(project5);

	}


}
