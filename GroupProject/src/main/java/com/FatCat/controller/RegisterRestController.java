package com.FatCat.controller;

import com.FatCat.GroupProjectApplication;
import com.FatCat.entity.User;
import com.FatCat.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.FatCat.controller.RestController.home;

@Controller
public class RegisterRestController {

    @GetMapping("/signup")
    public String register(Model model){

        model.addAttribute("user", new User());
        return "user-registration-form";

    }

    @PostMapping("/register/processRegistrationForm")
    public String saveUser(@ModelAttribute("user") User user, Model model){

        if(GroupProjectApplication.theUserRepository
                .findByUsername(user.getUsername()) == null){
            user.setEnabled(1);
            user.setRole("ROLE_STUDENT");
            user.setPassword("{noop}" + user.getPassword());
            GroupProjectApplication.theUserRepository.save(user);
        }

        model.addAttribute("user", user);
        return home(model);
    }
}
