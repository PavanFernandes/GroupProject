package com.FatCat;

import com.FatCat.repositoryService.TagRepository;
import com.FatCat.repositoryService.UserRepository;
import com.FatCat.repositoryService.ProjectRepository;
import com.FatCat.entity.project.Project;
import com.FatCat.entity.project.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class GroupProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupProjectApplication.class, args);

//		load2();

		Optional<Project> op = theprojectRepository.findById(1);
		if(op.isPresent()){
			Project project =  op.get();
			System.out.println(project.getTitle());
			List<Tag> tags = project.getTags();

			tags.forEach(t-> System.out.println(t.toString()));
		}
		else {
			System.out.println("not found");
		}

	}

	public static void load2(){

		Tag java = new Tag("java");
		Tag javascript = new Tag("java script");
		Tag python = new Tag("python");
		Tag csharp = new Tag("C#");
		Tag jenkins = new Tag("jenkins");
		Tag spring = new Tag("spring");


		Project project1 = new Project("Fat CAt", "this is project made for fun");
		Project project2 = new Project("MIT App Inventor", "Anyone can build apps with global impact");
		Project project3 = new Project("AOSSIE", " Australian Umbrella Org for Open-Source Projects");
		Project project4 = new Project("libvirt", "Libvirt is a library and toolkit providing abstraction for various hypervisors. It can be used from a number of languages.");
		Project project5 = new Project("Jenkins X", "Accelerate Your Continuous Delivery on Kubernetes");



		project1.addTag(java);
        project1.addTag(spring);
		project2.addTag(javascript);
		project3.addTag(python);
		project4.addTag(csharp);
		project5.addTag(jenkins);



		theprojectRepository.save(project1);
		theprojectRepository.save(project2);
		theprojectRepository.save(project3);
		theprojectRepository.save(project4);
		theprojectRepository.save(project5);

	}

	public static ProjectRepository theprojectRepository;
	public static TagRepository theTagRepository;
	public static UserRepository theUserRepository;


	@Autowired
	GroupProjectApplication(ProjectRepository projectRepository, TagRepository tagRepository, UserRepository userRepository){
         theprojectRepository = projectRepository;
		 theTagRepository = tagRepository;
		 theUserRepository = userRepository;
	}



	public static void load(){

		Tag java = new Tag("java");
		Tag javascript = new Tag("java script");
		Tag python = new Tag("python");
		Tag csharp = new Tag("C#");
		Tag jenkins = new Tag("jenkins");
		Tag spring = new Tag("spring");



		theTagRepository.save(java);
		theTagRepository.save(spring);
		theTagRepository.save(javascript);
		theTagRepository.save(python);
		theTagRepository.save(csharp);
		theTagRepository.save(jenkins);


		Project project1 = new Project("Fat CAt", "this is project made for fun");
		Project project2 = new Project("MIT App Inventor", "Anyone can build apps with global impact");
		Project project3 = new Project("AOSSIE", " Australian Umbrella Org for Open-Source Projects");
		Project project4 = new Project("libvirt", "Libvirt is a library and toolkit providing abstraction for various hypervisors. It can be used from a number of languages.");
		Project project5 = new Project("Jenkins X", "Accelerate Your Continuous Delivery on Kubernetes");


		theTagRepository.findById(1).get().addProjects(project1);
		theprojectRepository.save(project5);
		theTagRepository.findById(3).get().addProjects(project2);
		theTagRepository.findById(4).get().addProjects(project4);
		theTagRepository.findById(5).get().addProjects(project3);
		theTagRepository.findById(6).get().addProjects(project1);

		theprojectRepository.save(project1);
		theprojectRepository.save(project2);
		theprojectRepository.save(project3);
		theprojectRepository.save(project4);

	}

}
