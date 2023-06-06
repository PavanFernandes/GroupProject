package com.FatCat.controller;


import com.FatCat.dao.TaskDaoImpl;
import com.FatCat.entity.Project;
import com.FatCat.entity.Tag;
import com.FatCat.entity.Task;
import com.FatCat.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

import static com.FatCat.GroupProjectApplication.*;
import static com.FatCat.controller.RestController.home;

@Controller
public class ProjectController {


    @GetMapping("/new/project")
    public String addNewProject(Model model){
        List<Tag> tags = theTagRepository.findAll();
        model.addAttribute("tags", tags);
        model.addAttribute("project", new Project());
        return "project-register-form";

    }

    @PostMapping("/project/process-form")
    public String saveProject(@ModelAttribute("project") Project project,
                              Model model, Authentication authentication){

            project.setTimeStamp(LocalDateTime.now());

            User user = theUserRepository.findByUsername(authentication.getName());
            user.getProjects().add(project);
            theUserRepository.save(user);

//            project.getMembers().add(user);
//            System.out.println(user.getUsername());
//            System.out.println(project.toString());
//            theprojectRepository.save(project);

              return "redirect:/";
    }

    @GetMapping("/home/project/{title}")
    public String processProjectData(@PathVariable String title, Model model) {

        Project project = theprojectRepository.findByTitle(title);
        List<Task> tasks = TaskDaoImpl.findAllByProject(project.getId());
        model.addAttribute("tasks", tasks);
        model.addAttribute("project", project);
        model.addAttribute("task", new Task());

        return "project-details";
    }

    @PostMapping("/home/project/{title}/task")
    public String addTask(@PathVariable String title, @ModelAttribute("task") Task task){
        System.out.println(title);
        task.setCreatedDateTime(LocalDateTime.now());
        Project project = theprojectRepository.findByTitle(title);
        project.addTask(task);

        theprojectRepository.save(project);

        return "redirect:/";
    }

}
