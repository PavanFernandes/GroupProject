package com.FatCat.controller;

import com.FatCat.GroupProjectApplication;
import com.FatCat.dao.ProjectDaoServiceImpl;
import com.FatCat.entity.project.Project;
import com.FatCat.entity.project.Tag;
import com.FatCat.repositoryService.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.FatCat.GroupProjectApplication.theprojectRepository;

@Controller
public class RestController {

    @GetMapping("/welcome")
    public String show(){

        return "welcome";

    }

    @GetMapping("/")
    public static String home(Model model){

        List<Project> projects = theprojectRepository.findAll();

        model.addAttribute("projects", projects);

        List<Tag> tags = GroupProjectApplication.theTagRepository.findAll();

        model.addAttribute("tags", tags);

        return "home";

    }

    @GetMapping("/home/project/{title}")
    public String processProjectData(@PathVariable String title, Model model) {

        Project project = theprojectRepository.findByTitle(title);

        model.addAttribute("project", project);
        return "project-details";
    }

    @GetMapping("/chat")
    public String addNewProject(){

        return "chat";

    }


    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                  Model theModel) {

        List<Project> projects;

        if(theSearchName.length()<1){
            projects = theprojectRepository.findAll();

        } else{

            // search project from the service
           projects = theprojectRepository.findByTitleLike(theSearchName);
        }

        // add the projects to the model
        theModel.addAttribute("projects", projects );
        return "home";
    }

}
