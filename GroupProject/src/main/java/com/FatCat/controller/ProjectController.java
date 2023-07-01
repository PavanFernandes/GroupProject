package com.FatCat.controller;

import com.FatCat.entity.Project;
import com.FatCat.entity.Tag;
import com.FatCat.entity.Task;
import com.FatCat.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.FatCat.GroupProjectApplication.*;

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
            theUserDao.SaveProject(user.getId() , project);

              return "redirect:/";
    }

    @GetMapping("/home/project/{title}")
    public String processProjectData(@PathVariable String title, Model model) {

        Project project = theprojectRepository.findByTitle(title);
        List<Task> tasks = theUserDao.findAllByProject(project.getId());
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

    @GetMapping("/home/{username}/myProjects")
    public String showMyProjects(@PathVariable String username, Model model){

        User user = theUserRepository.findByUsername(username);
        List<Project> projects = user.getProjects();
        model.addAttribute("projects", projects);

        return "myprojects";
    }

    @GetMapping("/delete/projects/{projectId}")
    public String deleteProject(@PathVariable int projectId, Model model, Authentication authentication){

        Project project = theprojectRepository.findById(projectId).get();


        User user = theUserRepository.findByUsername(authentication.getName());

            project.getMembers().forEach(u-> u.getProjects().remove(project));
            project.getTags().forEach(t-> t.getProjects().remove(project));

            project.removeMember(user);
            project.getTags().clear();

//        user.getProjects().remove(project);
            theprojectRepository.save(project);
            theprojectRepository.delete(project);


        return "redirect:/home/" + authentication.getName() + "/myProjects";
    }

}
